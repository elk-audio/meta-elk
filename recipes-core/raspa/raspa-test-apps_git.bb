SUMMARY = "Install raspa test apps to the file system"

require raspa-common.inc

EXTRA_OECMAKE += "\
    -DRASPA_WITH_APPS=ON \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 apps/test_tone ${D}${bindir}/raspa_test_tone
    install -m 0755 apps/loopback ${D}${bindir}/raspa_loopback
    install -m 0755 apps/load_test ${D}${bindir}/raspa_load_test
    install -m 0755 apps/raspa_signal_recorder ${D}${bindir}/.
}

FILES:${PN} = "\
    ${bindir} \
    ${bindir}/* \
"