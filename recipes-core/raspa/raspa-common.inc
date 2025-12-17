# Raspa common definitions

# if DISTRO features has evl, then RASPA depends on libevl, else it depends on xenomai-lib
DEPENDS:append = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'evl', 'libevl', 'xenomai-lib', d)} \
"

DEPENDS:append = "\
    alsa-lib \
    libsndfile1 \
"

PV = "1.2.1"
SRC_URI = "gitsm://github.com/elk-audio/raspa;protocol=https;nobranch=1"
SRCREV = "3758010c3fb8cb12e3c36de37a35899d33fdb716"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DBUILD_GMOCK=OFF \
    -DINSTALL_GTEST=OFF \
    -DRASPA_WITH_PIPEWIRE=OFF \
    -DRASPA_WITH_TESTS=OFF \
    -DRASPA_WITH_APPS=OFF \
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
