SUMMARY = "Recipe for NAT-PMP python library"
HOMEPAGE = "https://github.com/jaraco/nat-pmp/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/jaraco/nat-pmp;protocol=https;nobranch=1 \
    file://0001-Remove-setup_scm-dependency.patch \
    "

SRCREV = "893fc848023af542c4f9516d512012a7f4a911a1"

S = "${WORKDIR}/git/"

inherit setuptools3

DEPENDS += "python3-setuptools-scm \
    python3-setuptools-scm-native"

RDEPENDS_${PN} += "python3-netifaces"

