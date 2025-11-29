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
SRCREV = "bd91c0672b8f538209eb97f4d23c8baadb02eb0e"

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
