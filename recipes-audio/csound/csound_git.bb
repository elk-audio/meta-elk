# Adapted from recipe in meta-musicians layer:
# https://github.com/schnitzeltony/meta-musicians/tree/master/recipes-musicians/csound
# with tweaks for headless build and minimizing dependencies for Elk
# Original license: MIT

SUMMARY = "A sound and music computing system"
HOMEPAGE = "https://csound.com/"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

# TBD: fltk is not propely detected
DEPENDS += "\
    flex-native \
    bison-native \
    swig-native \
    python3 \
    libsndfile1 \
    fluidsynth \
    curl \
    liblo \
    stk \
    libvorbis \
    libeigen \
    libwebsockets \
"

PV = "6.13.0"
SRC_URI = "\
    git://github.com/csound/csound.git;nobranch=1 \
    file://0001-Do-not-set-include-path-to-usr-local-include.patch \
    file://0002-Do-not-use-try_run-for-portaudio.patch \
"
SRCREV = "3b08a449cc147dec35ba843ced86e0058a9ac865"

S = "${WORKDIR}/git"

inherit cmake gettext python3-dir

# Where to get lua-version from?
LUA_VERSION = "5.3"
PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'pulseaudio', d)}"
PACKAGECONFIG[pulseaudio] = "-DUSE_PULSEAUDIO=ON,-DUSE_PULSEAUDIO=OFF,pulseaudio,pulseaudio-server"
PACKAGECONFIG[luajit] = "-DLUA_MODULE_INSTALL_DIR=${libdir}/lua/${LUA_VERSION},,luajit"

EXTRA_OECMAKE += "\
    -DUSE_DOUBLE=OFF \
    -DBUILD_BELA=OFF \
    -DBUILD_CUDA_OPCODES=OFF \
    -DBUILD_FRAMEBUFFER_OPCODES=OFF \
    -DBUILD_IMAGE_OPCODES=OFF \
    -DBUILD_JACK_OPCODES=OFF \
    -DUSE_ALSA=OFF \
    -DUSE_AUDIOUNIT=OFF \
    -DUSE_COREMIDI=OFF \
    -DUSE_FLTK=OFF \
    -DUSE_JACK=OFF \
    -DUSE_PORTAUDIO=OFF \
    -DUSE_PORTMIDI=OFF \
    -DUSE_PULSEAUDIO=OFF \
    -DBUILD_PYTHON_INTERFACE=OFF \
    -DPYTHON_MODULE_INSTALL_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DUSE_LIB64=${@bb.utils.contains("baselib", "lib64", "ON", "OFF",d)} \
"

OECMAKE_C_FLAGS_RELEASE += " -O3 -ffast-math"
OECMAKE_CXX_FLAGS_RELEASE += " -O3 -ffast-math"

PACKAGES =+ "\
    ${PN}-python3 \
    ${PN}-luajit \
"

FILES_${PN}-python3 = "${PYTHON_SITEPACKAGES_DIR}"
FILES_${PN}-luajit = "${libdir}/lua"

RDEPENDS_${PN}-python3 += "python3"

