SUMMARY = "A user space library for accessing the rtdm audio driver and device"
HOMEPAGE = "https://github.com/elk-audio/raspa"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

# if DISTRO features has evl, then RASPA depends on libevl, else it depends on xenomai-lib
DEPENDS:append = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'evl', 'libevl', 'xenomai-lib', d)} \
"

DEPENDS:append = "\
    alsa-lib \
"

PV = "1.0.0"
SRC_URI = "gitsm://github.com/elk-audio/raspa;protocol=https;nobranch=1"
SRCREV = "564e0814f3b265a255419acb360240077480ef20"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DBUILD_GMOCK=OFF \
    -DINSTALL_GTEST=OFF \
    -DRASPA_WITH_TESTS=OFF \
    -DRASPA_WITH_APPS=ON \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DWITH_UNIT_TESTS=FALSE \
"

# if DISTRO features has evl, then enable WITH_EVL option
EXTRA_OECMAKE += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'evl', '-DRASPA_WITH_EVL=TRUE', '-DRASPA_WITH_EVL=FALSE', d)} \
"

# Set CMAKE optimization flags
OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev ${PN}-test-apps"

RDEPENDS:${PN}-staticdev = ""
RDEPENDS:${PN}-dev = ""
RDEPENDS:${PN}-dbg = ""

do_install:append() {
    install -d ${D}${bindir}
    install -m 0755 apps/test_tone ${D}${bindir}/raspa_test_tone
    install -m 0755 apps/loopback ${D}${bindir}/raspa_loopback
    install -m 0755 apps/load_test ${D}${bindir}/raspa_load_test
}

FILES:${PN}-test-apps = "\
    ${bindir} \
"