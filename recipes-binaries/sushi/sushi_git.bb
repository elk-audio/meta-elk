SUMMARY = "Headless plugin host for ELK Audio OS."
HOMEPAGE = "https://github.com/elk-audio/sushi"

LICENSE = "AGPL-3.0-only"
LIC_FILES_CHKSUM = "\
    file://COPYING;md5=3db23ab95801691a1b98ff9ddb8dc98b \
    file://test/gtest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://third-party/spdlog/LICENSE;md5=bd5cc7fa6ff5ee46fc1047f0f0c895b7 \
    file://third-party/rapidjson/license.txt;md5=ba04aa8f65de1396a7e59d1d746c2125 \
    file://third-party/rapidjson/bin/jsonschema/LICENSE;md5=9d4de43111d33570c8fe49b4cb0e01af \
    file://third-party/rapidjson/contrib/natvis/LICENSE;md5=ec259ab094c66e4776e1da8b023540e0 \
    file://third-party/rapidjson/thirdparty/gtest/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://third-party/rapidjson/thirdparty/gtest/googlemock/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
    file://third-party/rapidjson/thirdparty/gtest/googlemock/scripts/generator/LICENSE;md5=2c0b90db7465231447cf2dd2e8163333 \
    file://third-party/vst3sdk/public.sdk/LICENSE.txt;md5=514d9812d1e91c0be05f58b713ee75f3 \
    file://third-party/vst3sdk/pluginterfaces/LICENSE.txt;md5=0b0ce4a82ab708ef3811b4993aa7a047 \
    file://third-party/vst3sdk/base/LICENSE.txt;md5=514d9812d1e91c0be05f58b713ee75f3 \
"

DEPENDS = "\
    raspa \
    twine \
    liblo \
    alsa-utils \
    libsndfile1 \
    grpc \
    grpc-native \
    protobuf \
    protobuf-native \
    protobuf-c \
    protobuf-c-native\
    lv2 \
    lilv \
"
# if DISTRO features has evl, then SUSHI depends on libevl, else it depends on xenomai-lib
DEPENDS += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'evl', 'libevl', 'xenomai-lib', d)} \
"

# Note: Same as SRCREV; Overide in meta-<product>
PV = "1.1.0"

SRC_URI = "\
    gitsm://github.com/elk-audio/sushi;protocol=https;nobranch=1 \
    file://sushi \
"

# NOTE: Override this in the meta-<product> layer with a
# .bbappend recipe choosing the specific commit required"
SRCREV = "2f27d9c04ad803014af5bbd81ada7ba1c702dfce"

S = "${WORKDIR}/git"

SUPPORTED_BUFFER_SIZES="16 32 64 128 256 512"

# NOTE: the following library dependencies are unknown, ignoring: cobalt Cocoa
#       (this is based on recipes that have previously been built and packaged)
inherit cmake python3native

# Default config of SUSHI should take care of compiling under cross environments
# THe following list is more for readability and fulfills the need to be explicit
EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DSUSHI_BUILD_TWINE=OFF \
    -DSUSHI_RASPA_FLAVOR=evl \
    -DSUSHI_TWINE_STATIC=OFF \
    -DSUSHI_WITH_ALSA_MIDI=ON \
    -DSUSHI_WITH_JACK=OFF \
    -DSUSHI_WITH_LINK=ON \
    -DSUSHI_WITH_LV2=ON \
    -DSUSHI_WITH_LV2_MDA_TESTS=OFF \
    -DSUSHI_WITH_PORTAUDIO=OFF \
    -DSUSHI_WITH_RASPA=ON \
    -DSUSHI_WITH_RPC_INTERFACE=TRUE \
    -DSUSHI_WITH_RT_MIDI=OFF \
    -DSUSHI_WITH_UNIT_TESTS=OFF \
    -DSUSHI_WITH_VST3=TRUE \
    -DSUSHI_WITH_APPLE_COREAUDIO=OFF \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
"

# Add VST2 support if VST2SDK_PATH variable in local.conf is set and not empty.
EXTRA_OECMAKE += "${@bb.utils.contains('VST2SDK_PATH', \
                 '', \
                 ' -DSUSHI_WITH_VST2=TRUE -DSUSHI_VST2_SDK_PATH=' + d.getVar('VST2SDK_PATH'), \
                 ' -DSUSHI_WITH_VST2=FALSE ' \
                 , d)}"

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
        -DSUSHI_AUDIO_BUFFER_SIZE=$b

        cmake_runcmake_build --target ${OECMAKE_TARGET_COMPILE}
        mv ${WORKDIR}/build/sushi ${WORKDIR}/build/sushi_b$b
    done
}

do_install:append() {
    for b in ${SUPPORTED_BUFFER_SIZES};
    do
        chrpath -d sushi_b$b
        install -m 0755 sushi_b$b ${D}${bindir}
    done
    install -m 0755 ${WORKDIR}/sushi ${D}${bindir}
}

RDEPENDS:{PN} = "\
    twine \
    raspa \
"

# if DISTRO features has evl, then SUSHI Rdepends on libevl, else it Rdepends on xenomai-lib
RDEPENDS:{PN}:append = "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'evl', 'libevl', 'xenomai-lib', d)} \
"

INSANE_SKIP:${PN} += "dev-deps"
