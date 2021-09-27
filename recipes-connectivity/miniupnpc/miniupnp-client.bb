SUMMARY = "A custom recipe to install miniupnp client"
HOMEPAGE = "http://miniupnp.free.fr/"
LICENSE = "miniupnpc"
LIC_FILES_CHKSUM = "file://LICENSE;md5=412eb0d8803af0731e98dfec30cd701d"
NO_GENERIC_LICENSE[miniupnpc] = "LICENSE"

SRC_URI = "git://github.com/miniupnp/miniupnp.git;protocol=https \
    file://0001-Patch-for-aloha.patch;striplevel=2 \
    "

PV = "1.0+git${SRCPV}"
SRCREV = "384268ac46e9ae337438f73382c967406804bc60"

S = "${WORKDIR}/git/miniupnpc"

inherit setuptools3

