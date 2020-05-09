SUMMARY = "A custom recipe to install miniupnp client"
HOMEPAGE = "http://miniupnp.free.fr/"
LICENSE = "miniupnpc"
LIC_FILES_CHKSUM = "file://LICENSE;md5=11993c723f7a8a97f5f849e86d7d8e44"
NO_GENERIC_LICENSE[miniupnpc] = "LICENSE"

SRC_URI = "git://github.com/miniupnp/miniupnp.git;protocol=https"

PV = "1.0+git${SRCPV}"
SRCREV = "388d93d678fb5659383463222ec22d0b087b2c4f"

S = "${WORKDIR}/git/miniupnpc"

inherit setuptools3

