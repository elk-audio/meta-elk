SUMMARY = "Twine multicore library for Xenomai"
LICENSE = "GPLv3"

inherit cmake

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/twine-public-mirror.git;protocol=ssh;nobranch=1"

LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

# SRCREV should be mentioned in the product layer as it will be specific to that.
SRCREV = ""

PV = "0.1.0+${SRCREV}"

S = "${WORKDIR}/git"

DEPENDS = "xenomai-lib"

EXTRA_OECMAKE += "-DTWINE_WITH_XENOMAI=TRUE -DTWINE_WITH_TESTS=FALSE -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai"