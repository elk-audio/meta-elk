SUMMARY = "Zix is a lightweight C library of portability wrappers and data structures."
HOMEPAGE = "http://drobilla.net/software/zix"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=c17d0f531d833bea1a6c6823ba18c242"

inherit meson

PV = "0.6.2"

SRC_URI = " \
    https://download.drobilla.net/${BPN}-${PV}.tar.xz \
"
SRC_URI[sha256sum] = "4bc771abf4fcf399ea969a1da6b375f0117784f8fd0e2db356a859f635f616a7"
