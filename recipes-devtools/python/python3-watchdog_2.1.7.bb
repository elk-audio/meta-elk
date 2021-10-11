SUMMARY = "Recipe for Watchdog python library"
HOMEPAGE = "https://github.com/gorakhargosh/watchdog/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "git://github.com/gorakhargosh/watchdog/;protocol=https;nobranch=1 \
    "

SRCREV = "57e80a504035892772858d018df542ffb3da0bf3"

S = "${WORKDIR}/git/"

inherit setuptools3

