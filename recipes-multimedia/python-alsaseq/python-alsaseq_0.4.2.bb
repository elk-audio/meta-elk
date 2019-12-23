# Recipe created by recipetool

SUMMARY = "ALSA sequencer bindings for Python"
HOMEPAGE = "http://pp.com.mx/python/alsaseq/"
LICENSE = "GPLv2 & GPL-v2-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/ppaez/alsaseq.git;protocol=https"
DEPENDS = "alsa-utils"

# Modify these as desired
PV = "0..4.2+git${SRCPV}"
SRCREV = "4f9be5945cbabf511ea6c38beb19e50e3c123a95"

S = "${WORKDIR}/git"

inherit setuptools3

do_install_append() {
    rm -rf ${D}/usr/share
}

