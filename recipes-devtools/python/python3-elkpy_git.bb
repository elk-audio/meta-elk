SUMMARY = "A simple wrapper for controlling sushi over gRPC via a python script"
HOMEPAGE = "https://github.com/elk-audio/elkpy"
SECTION = "devel/python"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

SRCREV = "35c73463cb944ccfb164d07b0e0626346627a834"

PV = "1.3.0"

SRC_URI = "gitsm://github.com/elk-audio/elkpy;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

inherit python_setuptools_build_meta

# Usually this is handled by setuptools and (something else?). but the files
# seem to be missing in the rootfs when do_install is completed.
do_install:append() {
    cp -r ${S}/src/elkpy ${D}${PYTHON_SITEPACKAGES_DIR}/.
}

RDEPENDS:${PN} = "\
    sushi \
    python3-protobuf \
    liberation-fonts \
    python3-grpcio  \
    python3-grpcio-tools  \
"

FILES:${PN}:append = "\
    ${PYTHON_SITEPACKAGES_DIR}/elkpy \
"

BBCLASSEXTEND = "native nativesdk"
