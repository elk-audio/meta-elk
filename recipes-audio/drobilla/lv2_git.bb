# LV2 libraries and tools recipes.
# All the recipes in this folder are adapted from those in:
# https://github.com/schnitzeltony/meta-musicians/tree/master/recipes-musicians/drobilla
# original license: MIT

require ${BPN}.inc

DEPENDS = "libsndfile1"

EXTRA_OECONF = "--libdir=${libdir}"

FILES_${PN} += "${datadir}"
