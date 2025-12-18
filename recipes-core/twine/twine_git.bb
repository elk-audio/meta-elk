SUMMARY = "Thread and Worker INterface for Elk Audio OS"
DESCRIPTION = "Support library for managing realtime threads and worker pools"
HOMEPAGE = "https://github.com/elk-audio/twine"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

# if DISTRO features has evl, then twine depends on libevl, else it depends on xenomai-lib
DEPENDS += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'evl', 'libevl', 'xenomai-lib', d)} \
    elk-warning-suppressor \
"

# SRCREV should be mentioned in the product layer as it will be specific to that.
SRCREV = "fd59ddf7ae734bc90dc5fe5fe67e5aa4744eff84"

# The specific version should be overidden in the meta-product layers
PV = "1.0.0"

SRC_URI = "gitsm://github.com/elk-audio/twine;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "\
    -DTWINE_WITH_TESTS=FALSE \
    -DTWINE_EXPOSE_INTERNALS=TRUE \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DTWINE_USE_INCLUDED_WARNING_SUPPRESSOR=FALSE \
"
EXTRA_OECMAKE += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'evl', '-DTWINE_WITH_EVL=TRUE', '-DTWINE_WITH_XENOMAI=TRUE', d)} \
"
