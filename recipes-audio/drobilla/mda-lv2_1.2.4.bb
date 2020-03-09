SUMMARY = "MDA-LV2 is an LV2 port of the MDA plugins by Paul Kellett"
HOMEPAGE = "https://drobilla.net/software/mda-lv2"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit waf pkgconfig

DEPENDS = "lv2"

SRC_URI = "\
    http://download.drobilla.net/${BPN}-${PV}.tar.bz2 \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRC_URI[md5sum] = "57feb6b58b195f87f8b3e436f3b56076"
SRC_URI[sha256sum] = "a81a00e19594881174526cd6ee7a3e301236e0ca25191982f5c9af5eb8d96ca8"

MDA_PLUGIN_DIR = "/home/mind/plugins/mda-lv2"

EXTRA_OECONF = " \
    --lv2dir=${MDA_PLUGIN_DIR}/ \
"

FILES_${PN} += "${MDA_PLUGIN_DIR}"
FILES_${PN} += "${MDA_PLUGIN_DIR}/*"