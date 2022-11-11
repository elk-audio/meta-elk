SUMMARY = "Simple Qt5 Quick application"
SECTION = "examples"
HOMEPAGE = "https://github.com/shigmas/BasicQuick.git"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "\
    qtbase \
    qtdeclarative \
    qtquickcontrols2 \
"

SRC_URI = "git://github.com/shigmas/BasicQuick.git;branch=master;protocol=https"
SRCREV = "bf7bd0c462cf2d760278ae0a4fed9c36e11f3fba"
S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}${bindir}
    install -m 0755 BasicQuick ${D}${bindir}/simple-qt
}