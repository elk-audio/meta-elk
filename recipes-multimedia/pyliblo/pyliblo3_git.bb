SUMMARY = "Python bindings for the liblo OSC library"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

DEPENDS += "\
    liblo \
    python3-cython \
    python3-cython-native \
"

SRCREV = "72ddb3d31c032071150a98ff1d3488edc5a1560d"

PV = "0.16.2"

SRC_URI = "gitsm://github.com/gesellkammer/pyliblo3.git;protocol=https;nobranch=1 \
           file://0001-Remove-hardcoded-include-paths.patch \
          "

S = "${WORKDIR}/git"

inherit setuptools3 pkgconfig

RDEPENDS:${PN} += "python3-core liblo"
