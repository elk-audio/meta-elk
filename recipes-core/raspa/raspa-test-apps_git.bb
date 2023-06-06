SUMMARY = "Raspa test applications"
HOMEPAGE = "https://github.com/elk-audio/raspa"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

require raspa-common.inc

EXTRA_OECMAKE += "\
    -DRASPA_WITH_APPS=ON \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 apps/raspa_test_tone ${D}${bindir}
    install -m 0755 apps/raspa_loopback ${D}${bindir}
    install -m 0755 apps/raspa_load_test ${D}${bindir}
    install -m 0755 apps/raspa_signal_recorder ${D}${bindir}
}

FILES:${PN} = "\
    ${bindir} \
    ${bindir}/* \
"
