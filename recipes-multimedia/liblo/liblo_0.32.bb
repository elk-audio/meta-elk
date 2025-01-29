SUMMARY = "liblo is an implementation of the Open Sound Control protocol"
HOMEPAGE = "https://github.com/radarsat1/liblo"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"
# 0.32
SRCREV = "c1a51bca21e8535ce77a9daf256f2e74c1a7e80f"

SRC_URI = "git://github.com/radarsat1/liblo.git;protocol=https;branch=master"
SRC_URI[sha256sum] = "2ff229bf2d87f9366eb65a4f98dca7b9280f947e3a80543e1b4d3e56cef69e42"

S = "${WORKDIR}/git"

inherit autotools pkgconfig
