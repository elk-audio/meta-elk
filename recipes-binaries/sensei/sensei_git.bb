SUMMARY = "A sensor & control abstraction daemon for Elk Audio OS."
HOMEPAGE = "https://github.com/elk-audio/sensei"
LICENSE = "AGPL-3.0-only"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=3db23ab95801691a1b98ff9ddb8dc98b \
    file://test/gtest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://third-party/spdlog/LICENSE;md5=13886a8d1692948ea9b78edc50e9447c \
    file://elk-gpio-protocol/COPYING;md5=e49f4652534af377a713df3d9dec60cb \
"

DEPENDS = " \
    liblo \
    jsoncpp \
    grpc \
    grpc-native \
"

# NOTE: You can override this in the meta-<product> layer with a
# .bbappend recipe choosing the specific commit required"
SRCREV = "d8d6503c70677d5fc34d7428f30b8b523fb83036"

# Note: Same as SRCREV; Overide in meta-<product>
PV = "1.0.0"

SRC_URI = "gitsm://github.com/elk-audio/sensei;protocol=https;nobranch=1"

inherit cmake python3native

OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"

# Set default build options
EXTRA_OECMAKE += " \
    -DCMAKE_BUILD_TYPE=Release \
    -DINSTALL_GTEST=OFF \
    -DSENSEI_WITH_GRPC=ON \
    -DWITH_GPIO_LOGIC=OFF \
    -DWITH_UNIT_TESTS=OFF \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 sensei ${D}${bindir}
}
