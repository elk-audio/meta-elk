# Recipe created by recipetool
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://test/gtest_1_7_0/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third-party/spdlog/LICENSE;md5=6e5242b8f24d08c5e948675102937cc9"

DEPENDS = "liblo jsoncpp libserialport"
SRC_URI = "gitsm://git@bitbucket.org/mindswteam/sensei.git;protocol=ssh;nobranch=1"

# Modify the following as desired in the product layer
SRCREV = ""
PV = ""

S = "${WORKDIR}/git/linux"

inherit cmake pythonnative

do_install() {
    install -d ${D}${bindir}
    install -m 0755 sensei ${D}${bindir}
}
