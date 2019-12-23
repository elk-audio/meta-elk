SUMMARY = "Twine multicore library for Xenomai"
LICENSE = "CLOSED"

inherit cmake

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/twine.git;protocol=ssh;nobranch=1"
SRCREV = "439b0534b49d79fa334c8e638ccca1afec87a9a3"

PV = "0.1.0+${SRCREV}"

S = "${WORKDIR}/git"

DEPENDS = "xenomai-lib"

EXTRA_OECMAKE += "-DTWINE_WITH_XENOMAI=TRUE -DTWINE_WITH_TESTS=FALSE -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai"

do_install_append() {
}

