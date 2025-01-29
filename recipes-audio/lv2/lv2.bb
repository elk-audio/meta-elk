DEPENDS = "libsndfile1"

EXTRA_OECONF = "--libdir=${libdir}"

FILES:${PN} += " \
    ${datadir} \
"

require ${BPN}.inc
