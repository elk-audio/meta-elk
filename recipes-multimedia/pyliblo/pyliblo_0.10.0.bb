SUMMARY = "Python bindings for the liblo OSC library"
HOMEPAGE = "http://das.nasophon.de/pyliblo/"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

DEPENDS += "\
    liblo \
    python3-cython \
    python3-cython-native \
"

PV = "0.10.0"

SRC_URI = "http://das.nasophon.de/download/pyliblo-${PV}.tar.gz"
SRC_URI[md5sum] = "1be68794dedaf8cc60748fe94fdb9628"
SRC_URI[sha256sum] = "fc67f1950b827272b00f9f0dc4ed7113c0ccef0c1c09e9976dead40ebbf1798f"

inherit setuptools3

RDEPENDS:${PN} += "python3-core"