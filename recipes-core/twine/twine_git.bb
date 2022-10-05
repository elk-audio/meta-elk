SUMMARY = "Thread and Worker INterface for Elk Audio OS"
DESCRIPTION = "Support library for managing realtime threads and worker pools"
HOMEPAGE = "https://github.com/elk-audio/twine"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

# The specific version should be oeridden in the meta-product layers
PV = ""

SRC_URI = "git://github.com/elk-audio/twine;protocol=https;nobranch=1"

# SRCREV should be mentioned in the product layer as it will be specific to that.
SRCREV = ""

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "\
    -DTWINE_WITH_XENOMAI=FALSE \
    -DTWINE_WITH_TESTS=FALSE \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
"
