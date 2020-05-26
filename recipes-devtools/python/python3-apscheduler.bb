SUMMARY = "Python apscheduler package"
HOMEPAGE = "https://github.com/agronholm/apscheduler"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

SRC_URI += "git://github.com/agronholm/apscheduler.git;protocol=https;nobranch=1"
SRCREV = "d1df878c02defcd14c5a56d4c3a70011744fa219"

S = "${WORKDIR}/git"

inherit setuptools3

RDEPENDS_${PN} += "python3-tzlocal"

