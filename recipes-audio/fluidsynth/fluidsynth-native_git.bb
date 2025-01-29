# Recipe for fluidsynth host tools

inherit native

do_install() {
    install -d ${D}/${bindir}
    install -m 755 ${B}/make_tables.exe ${D}/${bindir}/
}

require ${BPN}.inc

OECMAKE_SOURCEPATH = "${S}/src/gentables"
