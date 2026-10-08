# Libevl version R61
DEPENDS = "libbpf"

SRCREV = "db33f300adcfe70a3f15da02bb07342be611294f"
PV = "r61"

require libevl.inc

EVL_INCLUDE_DIR = "/usr/include/evl"

do_install:append() {
    install -d ${D}${EVL_INCLUDE_DIR}
    cp -r ${B}/include/evl/* ${D}${EVL_INCLUDE_DIR}/
}

FILES:${PN} += "${EVL_INCLUDE_DIR}/*"
