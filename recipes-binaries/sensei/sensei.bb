# Recipe created by recipetool
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://test/gtest_1_7_0/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third-party/spdlog/LICENSE;md5=6e5242b8f24d08c5e948675102937cc9"

DEPENDS = "liblo jsoncpp libserialport"
SRC_URI = "gitsm://git@bitbucket.org/mindswteam/sensei.git;protocol=ssh;nobranch=1"

# Modify these as desired in the product layer
SRCREV = ""

PV = "0.1.0+${SRCREV}"

S = "${WORKDIR}/git/linux"

inherit cmake pythonnative

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "-DWITH_UNIT_TESTS=FALSE"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 sensei ${D}${bindir}
}