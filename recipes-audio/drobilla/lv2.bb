require ${BPN}.inc

DEPENDS = "libsndfile1"

EXTRA_OECONF = "--libdir=${libdir}"

FILES_${PN} += " \
    ${datadir} \
"
