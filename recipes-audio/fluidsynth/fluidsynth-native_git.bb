# Recipe for fluidsynth host tools


do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${B}/make_tables.exe ${D}/${bindir}/
}

require ${BPN}.inc

inherit native

OECMAKE_SOURCEPATH = "${S}/src/gentables"

