SUMMARY = "Version R48"

require libevl.inc

PV = "r48"
SRCREV = "0716cf2ee4b040e29ad660494aa542309e25ccd9"

EVL_INCLUDE_DIR = "/usr/include/evl"

do_install:append() {
    install -d ${D}${EVL_INCLUDE_DIR}
    cp -r ${B}/include/evl/* ${D}${EVL_INCLUDE_DIR}/
}

FILES:${PN} += "${EVL_INCLUDE_DIR}/*"
