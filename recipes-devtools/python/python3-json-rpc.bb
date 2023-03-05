SUMMARY = "Python json rpc recipe"
HOMEPAGE = "https://pypi.org/project/json-rpc/"
PV = "1.13.0"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "git://github.com/pavlov99/json-rpc;protocol=https;tag=${PV}"
SRC_URI[md5sum] = "489a8d3943821cc2069af64ab53a79c4"
SRC_URI[sha256sum] = "12e4ee807466d80c779313ca3f3f0ecf2bf3e66af9e426ee0d7e4d1190effadb"

S = "${WORKDIR}/git"

inherit setuptools3

