SUMMARY = "MDA VST3 plugins for Linux"
LICENSE = "CLOSED"

inherit cmake

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/mda-vst3.git;protocol=ssh;nobranch=1"
SRC_URI += "file://0001-Added-DNDEBUG-compile-definition.patch"
SRC_URI += "file://0002-Removed-auto-strip-with-Release-build-as-Yocto-takes.patch"
SRCREV = "abbca58836ddeb9304a511c155dc0abcc1ba2b7d"

PV = "0.1.0+${SRCREV}"
S = "${WORKDIR}/git"

OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"
EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release"

MDA_PLUGIN_DIR = "/home/mind/plugins/mda-vst3"

do_install() {
    mv "${WORKDIR}/build/VST3/Release/mda.vst3/Contents/x86_64-linux"  "${WORKDIR}/build/VST3/Release/mda.vst3/Contents/${TARGET_ARCH}-linux"
    cp -r "${WORKDIR}/build/VST3/Release/mda.vst3" ${D}${MDA_PLUGIN_DIR}
}

FILES_${PN} += "${MDA_PLUGIN_DIR}"
FILES_${PN} += "${MDA_PLUGIN_DIR}/*"