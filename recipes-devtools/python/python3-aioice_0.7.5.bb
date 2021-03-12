SUMMARY = "Recipe for aioice python library"
HOMEPAGE = "https://github.com/aiortc/aioice"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f51a4013af37fa3764314e9b051513fd"

SRC_URI = "git://github.com/aiortc/aioice;protocol=https;nobranch=1"
SRCREV = "c71c3afe064a028a8f39bde45c95897dbbaba35f"

S = "${WORKDIR}/git/"

inherit setuptools3

