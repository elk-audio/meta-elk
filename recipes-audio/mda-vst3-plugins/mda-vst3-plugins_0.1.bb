SUMMARY = "MDA VST3 plugins for Linux"
LICENSE = "CLOSED"

inherit cmake

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/mda-vst3.git;protocol=ssh;nobranch=1"
SRC_URI += "file://0001-Added-DNDEBUG-compile-definition.patch"
SRCREV = "0f6c8e1e840a9897e156ce46e38e0ca2ba43684d"

PV = "0.1.0+${SRCREV}"
S = "${WORKDIR}/git"

OECMAKE_C_FLAGS += "-O3"
OECMAKE_CXX_FLAGS += "-O3"

MDA_PLUGIN_DIR = "/home/mind/plugins/mda-vst3"

do_install() {
    install -d ${D}${MDA_PLUGIN_DIR}
    cp -r "${WORKDIR}/build/VST3/mda.vst3" ${D}${MDA_PLUGIN_DIR}
}

FILES_${PN} += "${MDA_PLUGIN_DIR}"
FILES_${PN} += "${MDA_PLUGIN_DIR}/*"
