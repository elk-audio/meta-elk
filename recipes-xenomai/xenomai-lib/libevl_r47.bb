SUMMARY = "Version R47"
SRCREV = "3bbe1d092e021113b1aa238c7a51c8f634c6cdcc"
PV = "r47"

do_install:append() {
    install -d ${D}${EVL_INCLUDE_DIR}
    cp -r ${B}/include/evl/* ${D}${EVL_INCLUDE_DIR}/
}

FILES:${PN} += "${EVL_INCLUDE_DIR}/*"

require libevl.inc

EVL_INCLUDE_DIR = "/usr/include/evl"
