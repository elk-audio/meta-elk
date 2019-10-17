SUMMARY = "Twine multicore library for Xenomai"
LICENSE = "CLOSED"

inherit cmake

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/twine.git;protocol=ssh;nobranch=1"

# SRCREV should be mentioned in the product layer as it will be specific to that.
SRCREV = ""

PV = "0.1.0+${SRCREV}"

S = "${WORKDIR}/git"

DEPENDS = "xenomai-lib"

EXTRA_OECMAKE += "-DTWINE_WITH_XENOMAI=TRUE -DTWINE_WITH_TESTS=FALSE -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai"