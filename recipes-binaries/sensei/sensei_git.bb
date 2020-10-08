SUMMARY = "A sensor & control abstraction daemon for Elk Audio OS."
HOMEPAGE = "https://github.com/elk-audio/sensei"

LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "\
    file://COPYING;md5=3db23ab95801691a1b98ff9ddb8dc98b \
    file://test/gtest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://third-party/spdlog/LICENSE;md5=6e5242b8f24d08c5e948675102937cc9 \
    file://elk-gpio-protocol/COPYING;md5=e49f4652534af377a713df3d9dec60cb \
"

DEPENDS = "liblo jsoncpp"

# Note: Same as SRCREV; Overide in meta-<product>
PV = ""
SRC_URI = "gitsm://github.com/elk-audio/sensei;protocol=https;nobranch=1"

# NOTE: Override this in the meta-<product> layer with a
# .bbappend recipe choosing the specific commit required
SRCREV = ""

S = "${WORKDIR}/git/"

inherit cmake python3native

OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 sensei ${D}${bindir}
}
