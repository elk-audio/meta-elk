SUMMARY = "A simple wrapper for controlling sushi over gRPC via a python script"
HOMEPAGE = "https://github.com/elk-audio/elkpy"
SECTION = "devel/python"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

SRC_URI = "git://github.com/elk-audio/elkpy;protocol=https;nobranch=1"
SRCREV = "49a7d2e0485e0c3df6cb9c863f696ed9cbea5cfd"

S = "${WORKDIR}/git"
PV = "1.1.8"

inherit python_setuptools_build_meta

# Usually this is handled by setuptools and (something else?). but the files
# seem to be missing in the rootfs when do_install is completed.
do_install:append() {
    cp -r ${S}/src/elkpy ${D}${PYTHON_SITEPACKAGES_DIR}/.
}

FILES:${PN}:append = "\
    ${PYTHON_SITEPACKAGES_DIR}/elkpy \
"

RDEPENDS:${PN} = "\
    sushi \
    python3-grpcio \
    python3-grpcio-tools \
    python3-protobuf \
    liberation-fonts \
"

BBCLASSEXTEND = "native nativesdk"
