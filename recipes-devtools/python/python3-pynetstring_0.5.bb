SUMMARY = "Recipe for pynet string python library"
HOMEPAGE = "https://github.com/rj79/pynetstring"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8e471a7a507f34b60517db4493e19e23"

SRC_URI = "git://github.com/rj79/pynetstring;protocol=https;nobranch=1"
SRCREV = "6c0920763e9e342a3524a5a3a572ade576d412e8"

S = "${WORKDIR}/git"

inherit setuptools3

do_install:append(){
    rm -r ${D}${PYTHON_SITEPACKAGES_DIR}/tests
}

