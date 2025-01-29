SUMMARY = "Version R48"
SRCREV = "0716cf2ee4b040e29ad660494aa542309e25ccd9"
PV = "r48"

do_install:append() {
    install -d ${D}${EVL_INCLUDE_DIR}
    cp -r ${B}/include/evl/* ${D}${EVL_INCLUDE_DIR}/
}

FILES:${PN} += "${EVL_INCLUDE_DIR}/*"

require libevl.inc

EVL_INCLUDE_DIR = "/usr/include/evl"
