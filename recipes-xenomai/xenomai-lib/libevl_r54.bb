# Libevl version R54
DEPENDS = "libbpf"

SRCREV = "448812181400ff33800add14d9a7b3e9e8627f60"
PV = "r54"

require libevl.inc

EVL_INCLUDE_DIR = "/usr/include/evl"

do_install:append() {
    install -d ${D}${EVL_INCLUDE_DIR}
    cp -r ${B}/include/evl/* ${D}${EVL_INCLUDE_DIR}/
}

FILES:${PN} += "${EVL_INCLUDE_DIR}/*"
