SUMMARY = "MDA-LV2 is an LV2 port of the MDA plugins by Paul Kellett"
HOMEPAGE = "https://drobilla.net/software/mda-lv2"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "lv2"

SRCREV = "19752af61234581e0f73db539d5609ab14b3d928"
PV = "1.2.6"

SRC_URI = " \
    gitsm://gitlab.com/drobilla/mda-lv2.git;protocol=https;branch=master \
"

S = "${WORKDIR}/git"

inherit waf features_check pkgconfig

EXTRA_OECONF = " \
    --lv2dir=${libdir}/lv2 \
"

FILES:${PN} += "${libdir}/lv2"

REQUIRED_DISTRO_FEATURES = "x11"
