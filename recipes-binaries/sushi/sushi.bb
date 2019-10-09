# Recipe created by recipetool
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE;md5=817ab7bd0deff07f9f518bc30434cea3 \
                    file://raspalib/test/gtest_1_7_0/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://test/gtest_1_7_0/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third-party/spdlog/LICENSE;md5=6e5242b8f24d08c5e948675102937cc9 \
                    file://third-party/vstsdk2.4/vstgui.sf/vstgui/Documentation/html/license.html;md5=a0b7291eff176aa998343351b3abcdba \
                    file://third-party/vstsdk2.4/doc/html/license.html;md5=c3b5d06993a4faa04988fc48571b7e1f \
                    file://third-party/rapidjson/license.txt;md5=ba04aa8f65de1396a7e59d1d746c2125 \
                    file://third-party/rapidjson/bin/jsonschema/LICENSE;md5=9d4de43111d33570c8fe49b4cb0e01af \
                    file://third-party/rapidjson/contrib/natvis/LICENSE;md5=ec259ab094c66e4776e1da8b023540e0 \
                    file://third-party/rapidjson/thirdparty/gtest/googletest/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third-party/rapidjson/thirdparty/gtest/googlemock/LICENSE;md5=cbbd27594afd089daa160d3a16dd515a \
                    file://third-party/rapidjson/thirdparty/gtest/googlemock/scripts/generator/LICENSE;md5=2c0b90db7465231447cf2dd2e8163333 \
                    file://third-party/vstsdk3/public.sdk/LICENSE.txt;md5=78abdbd6f3bde7728ada2b0038a84d6f \
                    file://third-party/vstsdk3/pluginterfaces/LICENSE.txt;md5=6ab6901f1956626a2db4594a189fed5c \
                    file://third-party/vstsdk3/base/LICENSE.txt;md5=78abdbd6f3bde7728ada2b0038a84d6f \
                    file://third-party/EASTL/3RDPARTYLICENSES.TXT;md5=92e944b39f2bc8dc68b0a5cdc3cd9085 \
                    file://third-party/EASTL/LICENSE;md5=f2de4603fe498daf092ef9ab24e3c4e4"

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/sushi.git;protocol=ssh;nobranch=1"
SRC_URI += "file://sushi"

# NOTE: This is most likely overiden as desired from meta-<product> layer with a .bbappend recipe"
SRCREV = ""

#Note: Same as SRCREV; Overiden from meta-<product>
PV = ""

S = "${WORKDIR}/git"

SUPPORTED_BUFFER_SIZES="16 32 64 128"

# NOTE: the following library dependencies are unknown, ignoring: cobalt Cocoa
#       (this is based on recipes that have previously been built and packaged)
inherit cmake pythonnative
DEPENDS = "xenomai-lib twine liblo alsa-utils libsndfile1"
RDEPENDS_{PN} = "twine"

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
    rm -f ${D}/usr/LICENSE
    rm -rf ${D}/usr/example_configs/

    for b in ${SUPPORTED_BUFFER_SIZES};
    do
        chrpath -d sushi_b$b
        install -m 0755 sushi_b$b ${D}${bindir}
    done
    install -m 0755 ${WORKDIR}/sushi ${D}${bindir}
}

FILES_{PN} += "${D}${sysconfdir}/sushi_conf/*"
