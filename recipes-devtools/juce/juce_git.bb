DESCRIPTION = "JUCE C++ framework for cross-platform audio application development"
HOMEPAGE = "https://juce.com"
# JUCE 8.x is dual-licensed: AGPL-3.0-only for open-source, commercial otherwise.
LICENSE = "AGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=caa6f235144242bff9cf5d5206bf98ba"

inherit cmake

# pkgconfig-native: JUCEModuleSupport.cmake calls find_package(PkgConfig REQUIRED).
# freetype-native, fontconfig-native: required by the juceaide host build (see below).
DEPENDS = "pkgconfig-native freetype-native fontconfig-native"

SRC_URI = "git://github.com/juce-framework/JUCE;protocol=https;nobranch=1"
SRCREV = "29396c22c93392d6738e021b83196283d6e4d850"
PV = "8.0.12"
S = "${WORKDIR}/git"

# JUCE_TOOL_INSTALL_DIR sets the install location for juceaide relative to
# CMAKE_INSTALL_PREFIX. Must match the path used in FILES:${PN}-devtools below.
EXTRA_OECMAKE = " \
    -DJUCE_BUILD_EXAMPLES=OFF \
    -DJUCE_BUILD_EXTRAS=OFF \
    -DJUCE_TOOL_INSTALL_DIR=bin/JUCE-${PV} \
"

# juceaide bootstrap strategy:
#   JUCE's extras/Build/juceaide/CMakeLists.txt, when CMAKE_CROSSCOMPILING=TRUE,
#   unsets the cross-compile compiler vars and re-invokes cmake with
#   JUCE_BUILD_HELPER_TOOLS=ON to build juceaide natively. However two issues
#   arise in Yocto:
#
#   1. Yocto exports CFLAGS/CXXFLAGS with flags like -fcanon-prefix-map that
#      only its patched GCC supports. The bootstrap unsets CC/CXX but not FLAGS,
#      so the host gcc compiler test fails.
#
#   2. The bootstrap's cmake call picks up Yocto's native sysroot pkg-config
#      (first in PATH), whose compiled-in pc_path points to the pkgconfig-native
#      build sysroot — not to this recipe's recipe-sysroot-native where
#      freetype-native and fontconfig-native are installed. The juce_graphics
#      module needs freetype unconditionally on Linux (JUCE_USE_FREETYPE=1).
#
#   Fix: pre-build juceaide in a subshell before the main cmake configure, with:
#     - CC/CXX set to ${HOSTTOOLS_DIR}/gcc|g++ (Yocto-managed host compiler)
#     - CFLAGS/CXXFLAGS/CPPFLAGS unset
#     - PKG_CONFIG_LIBDIR set to the recipe's native sysroot pkgconfig dirs
#   JUCE's bootstrap cmake then finds the already-built ${B}/tools/ and its
#   cmake --build step finds nothing to rebuild.
do_configure:prepend() {
    rm -rf "${B}/tools"
    (
        unset AR AS LD NM OBJCOPY OBJDUMP RANLIB STRIP
        unset CFLAGS CXXFLAGS CPPFLAGS LDFLAGS
        # PKG_CONFIG_SYSROOT_DIR causes cmake's pkg_check_modules to prepend
        # the target sysroot to every pkg-config result include path.
        # PKG_CONFIG_LIBDIR is replaced with the native sysroot pkgconfig dirs.
        unset PKG_CONFIG_SYSROOT_DIR PKG_CONFIG_PATH
        export CC="${HOSTTOOLS_DIR}/gcc"
        export CXX="${HOSTTOOLS_DIR}/g++"
        export PKG_CONFIG_LIBDIR="${STAGING_DIR_NATIVE}/usr/lib/pkgconfig:${STAGING_DIR_NATIVE}/usr/share/pkgconfig"
        cmake "${S}" \
            -B"${B}/tools" \
            -GNinja \
            -DCMAKE_CONFIGURATION_TYPES=Custom \
            -DCMAKE_BUILD_TYPE=Custom \
            -DJUCE_BUILD_HELPER_TOOLS=ON \
            -DJUCE_BUILD_EXAMPLES=OFF \
            -DJUCE_BUILD_EXTRAS=OFF \
            -DCMAKE_INSTALL_PREFIX="${prefix}" \
        && cmake --build "${B}/tools" --config Custom
    ) || bbfatal "juceaide host-native pre-build failed"
}

# juce_lv2_helper: built unconditionally by the top-level JUCE CMakeLists.txt
# (no cmake option to disable in JUCE 8.x). Cross-compiled (aarch64), installed
# alongside juceaide. LV2 plugin support is not yet in scope for downstream
# recipes; this binary is bundled here for completeness.

# --------------------------------------------------------------------------
# Package layout
# --------------------------------------------------------------------------
#   ${PN}          — empty (pure build-time/SDK dep, no target runtime)
#   ${PN}-devtools — juceaide (host x86_64) + juce_lv2_helper (aarch64)
#   ${PN}-dev      — module headers + CMake config files
#   ${PN}-dbg      — populated by Yocto defaults if debug symbols are present
# --------------------------------------------------------------------------

PACKAGES =+ "${PN}-devtools"

# Both tool binaries are installed under ${bindir}/JUCE-${PV}/.
FILES:${PN}-devtools = "${bindir}/JUCE-${PV}/*"

# juceaide is an intentional x86_64 host binary in an aarch64 recipe.
# arch QA is skipped for the whole devtools package; juce_lv2_helper (aarch64)
# would pass the check anyway but is in the same directory.
INSANE_SKIP:${PN}-devtools += "arch"
# juceaide is an x86_64 host binary — its runtime deps (libc, libm,
# libfontconfig, libfreetype) are host libraries, not target packages.
# build paths are embedded in the debug-info of the host binary (expected).
INSANE_SKIP:${PN}-devtools += "file-rdeps buildpaths"

# Reinforce dev package paths (also covered by Yocto defaults for ${PN}-dev):
#   ${includedir}       → include/JUCE-${PV}/modules/  (module headers)
#   ${libdir}/cmake     → lib/cmake/JUCE-${PV}/        (JUCEConfig.cmake etc.)
FILES:${PN}-dev += " \
    ${includedir}/JUCE-${PV}/ \
    ${libdir}/cmake/JUCE-${PV}/ \
"

RDEPENDS:${PN}-dev = ""
RDEPENDS:${PN}-devtools = ""

# ${PN}-devtools contains juceaide (x86_64) and juce_lv2_helper (aarch64).
# The cross objcopy (aarch64-elk-linux-objcopy) cannot process the x86_64 binary.
# Inhibit strip and debug-split for the whole recipe (all packages are headers,
# cmake scripts, or binaries that need no cross-strip).
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
# do_populate_sysroot also runs sysroot_strip with the cross strip tool.
INHIBIT_SYSROOT_STRIP = "1"

# Main package has no files — JUCE installs only headers and build tools.
ALLOW_EMPTY:${PN} = "1"

# ${bindir} is not in SYSROOT_DIRS by default. juceaide must be sysroot-staged
# so that downstream recipes' find_package(JUCE) can resolve it via JUCEConfig.cmake.
SYSROOT_DIRS:append = " ${bindir}/JUCE-${PV}"
