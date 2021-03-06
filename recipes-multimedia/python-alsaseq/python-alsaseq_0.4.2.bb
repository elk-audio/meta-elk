SUMMARY = "ALSA sequencer bindings for Python"
HOMEPAGE = "http://pp.com.mx/python/alsaseq/"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "alsa-utils"
PV = "0.4.2+git${SRCPV}"

SRC_URI = "git://github.com/ppaez/alsaseq.git;protocol=https"
SRCREV = "4f9be5945cbabf511ea6c38beb19e50e3c123a95"

S = "${WORKDIR}/git"

inherit setuptools3

do_install_append() {
    rm -rf ${D}/usr/share
}