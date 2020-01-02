SUMMARY = "Headless plugin host for ELK Audio OS."
HOMEPAGE = "https://github.com/elk-audio/sushi"

LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "\
    file://COPYING;md5=3db23ab95801691a1b98ff9ddb8dc98b \
    file://test/gtest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://third-party/spdlog/LICENSE;md5=6e5242b8f24d08c5e948675102937cc9 \
    file://third-party/rapidjson/license.txt;md5=ba04aa8f65de1396a7e59d1d746c2125 \
    file://third-party/rapidjson/bin/jsonschema/LICENSE;md5=9d4de43111d33570c8fe49b4cb0e01af \
    file://third-party/rapidjson/contrib/natvis/LICENSE;md5=ec259ab094c66e4776e1da8b023540e0 \
    file://third-party/rapidjson/thirdparty/gtest/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://third-party/rapidjson/thirdparty/gtest/googlemock/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://third-party/rapidjson/thirdparty/gtest/googlemock/scripts/generator/LICENSE;md5=2c0b90db7465231447cf2dd2e8163333 \
    file://third-party/vst3sdk/public.sdk/LICENSE.txt;md5=cbd8a39170645aac3bbb1d6281723eeb \
    file://third-party/vst3sdk/pluginterfaces/LICENSE.txt;md5=b351e6cd8ecd13e18278f5c8c89ea7c0 \
    file://third-party/vst3sdk/base/LICENSE.txt;md5=cbd8a39170645aac3bbb1d6281723eeb \
"

DEPENDS = "\
    xenomai-lib \
    raspa \
    twine \
    liblo \
    alsa-utils \
    libsndfile1 \
"

# Note: Same as SRCREV; Overide in meta-<product>
PV = ""

SRC_URI = "\
    gitsm://github.com/elk-audio/sushi;protocol=https;nobranch=1 \
    file://sushi \
"

# NOTE: Override this in the meta-<product> layer with a
# .bbappend recipe choosing the specific commit required"
SRCREV = ""

S = "${WORKDIR}/git"

SUPPORTED_BUFFER_SIZES="16 32 64 128"

# NOTE: the following library dependencies are unknown, ignoring: cobalt Cocoa
#       (this is based on recipes that have previously been built and packaged)
inherit cmake pythonnative

# Set CMAKE optimization flags
OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"

# Override compilation step to build multiple binaries with different buffer sizes
do_compile() {
    for b in ${SUPPORTED_BUFFER_SIZES};
    do
        cmake \
        ${OECMAKE_GENERATOR_ARGS} \
        $oecmake_sitefile \
        ${OECMAKE_SOURCEPATH} \
        -DAUDIO_BUFFER_SIZE=$b

        cmake_runcmake_build --target ${OECMAKE_TARGET_COMPILE}
        mv ${WORKDIR}/build/sushi ${WORKDIR}/build/sushi_b$b
    done
}

do_install_append() {
    install -d ${D}${sysconfdir}/sushi_conf
    install -m 0644 ${S}/misc/config_files/config_empty.json ${D}${sysconfdir}/sushi_conf/
    rm -f ${D}/usr/README.md
    rm -f ${D}/usr/HISTORY.md
    rm -f ${D}/usr/LICENSE.md
    rm -rf ${D}/usr/example_configs/

    for b in ${SUPPORTED_BUFFER_SIZES};
    do
        chrpath -d sushi_b$b
        install -m 0755 sushi_b$b ${D}${bindir}
    done
    install -m 0755 ${WORKDIR}/sushi ${D}${bindir}
}

FILES_{PN} += "${D}${sysconfdir}/sushi_conf/*"

RDEPENDS_{PN} = "\
    twine \
    xenomai-lib \
"