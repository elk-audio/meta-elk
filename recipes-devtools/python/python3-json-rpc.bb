SUMMARY = "Python json rpc recipe"
HOMEPAGE = "https://pypi.org/project/json-rpc/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "https://github.com/pavlov99/json-rpc/archive/master.zip"
SRC_URI[md5sum] = "f705d5c2b45265c9a889a28e581f0df0"
SRC_URI[sha256sum] = "adc0107f3c389660efa6441bfb0c987eb675edb4533de02fd93091429aab372d"

S = "${WORKDIR}/json-rpc-master"

inherit setuptools3

