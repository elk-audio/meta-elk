SUMMARY = "MDA VST3 plugins for Linux"
HOMEPAGE = "http://mda.smartelectronix.com/"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

PV = "0.1.0+${SRCREV}"
SRC_URI = "\
    gitsm://github.com/elk-audio/mda-vst3;protocol=https;nobranch=1 \
    file://0001-Added-DNDEBUG-compile-definition.patch \
    file://0002-Removed-auto-strip-with-Release-build-as-Yocto-takes.patch \
"

SRCREV = "5b970765c49480880e6c945de7baf040ff703c50"

S = "${WORKDIR}/git"

inherit cmake

OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"
EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release"

MDA_PLUGIN_DIR = "/home/mind/plugins/mda-vst3"

do_install() {
    install -d ${D}${MDA_PLUGIN_DIR}/mda.vst3/Contents/${TARGET_ARCH}-linux
    cp "${WORKDIR}/build/VST3/Release/mda.vst3/Contents/x86_64-linux/mda.so" "${D}${MDA_PLUGIN_DIR}/mda.vst3/Contents/${TARGET_ARCH}-linux/"
}

FILES_${PN} += "${MDA_PLUGIN_DIR}"
FILES_${PN} += "${MDA_PLUGIN_DIR}/*"