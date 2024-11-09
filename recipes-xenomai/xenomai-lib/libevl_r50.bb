SUMMARY = "Version R50"

DEPENDS = "libbpf"

require libevl.inc

PV = "r50"
SRCREV = "c39165fc47042f3b98a32e709e8e244dc79fe165"

EVL_INCLUDE_DIR = "/usr/include/evl"

do_install:append() {
    install -d ${D}${EVL_INCLUDE_DIR}
    cp -r ${B}/include/evl/* ${D}${EVL_INCLUDE_DIR}/
}

FILES:${PN} += "${EVL_INCLUDE_DIR}/*"
