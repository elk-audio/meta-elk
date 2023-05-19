SUMMARY = "Install raspa test apps to the file system"

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