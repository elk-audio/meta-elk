SUMMARY = "LV2 is an open standard for audio plugins"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://COPYING;md5=b1b33d6fcf7d70cf1512e3c481768a9c"

SRC_URI = " \
    gitsm://github.com/lv2/lv2.git;branch=main;protocol=https \
    file://lv2-config.cmake \
"
S = "${WORKDIR}/git"
SRCREV = "0bcde338db1c63bbc503b4d1f6d7b55ed43154af"

PV = "1.18.10"

inherit meson pkgconfig

# Match vcpkg Meson configuration
EXTRA_OEMESON = " \
    -Ddocs=disabled \
    -Dplugins=disabled \
    -Dtests=disabled \
"

# Install CMake config file so other recipes can find LV2 via find_package()
do_install:append() {
    install -d ${D}${libdir}/cmake/lv2
    install -m 0644 ${WORKDIR}/lv2-config.cmake \
        ${D}${libdir}/cmake/lv2/lv2-config.cmake
}

FILES:${PN} += " \
    ${datadir} \
    ${libdir}/cmake/lv2 \
"

