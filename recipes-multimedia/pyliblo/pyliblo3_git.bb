SUMMARY = "Python bindings for the liblo OSC library"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

DEPENDS += "\
    liblo \
    python3-cython \
    python3-cython-native \
"

# 0.16.2
SRC_URI = "git://github.com/gesellkammer/pyliblo3.git;protocol=https;branch=master"
PV = "0.16.2"
SRCREV="72ddb3d31c032071150a98ff1d3488edc5a1560d" 

SRC_URI[md5sum] = "84a0c9be18259c8e35bb44a26d2a14a9"
SRC_URI[sha256sum] = "b87f289ae5b22af934a197302ac6ad4053ab9971776ee5fbe30f6c5b763768e7"

S = "${WORKDIR}/git"
inherit setuptools3 pkgconfig

RDEPENDS:${PN} += "python3-core liblo"

# TODO: this is hack to force pyliblo3 to use the right architecture
do_compile:prepend() {
    ln -sf ${STAGING_INCDIR}/python3.12/pyconfig-64.h ${STAGING_INCDIR}/python3.12/pyconfig-32.h
}