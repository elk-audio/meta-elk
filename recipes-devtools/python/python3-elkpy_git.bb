SUMMARY = "A simple wrapper for controlling sushi over gRPC via a python script"
HOMEPAGE = "https://github.com/elk-audio/elkpy"
SECTION = "devel/python"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

SRC_URI = "git://github.com/elk-audio/elkpy;protocol=https;nobranch=1"
SRCREV = "59bb27ec4772e9b04a523279cdbf1d846fe4c46d"

S = "${WORKDIR}/git"
PV = "1.2.0"

inherit python_setuptools_build_meta

# Usually this is handled by setuptools and (something else?). but the files
# seem to be missing in the rootfs when do_install is completed.
do_install:append() {
    cp -r ${S}/src/elkpy ${D}${PYTHON_SITEPACKAGES_DIR}/.
}

FILES:${PN}:append = "\
    ${PYTHON_SITEPACKAGES_DIR}/elkpy \
"

#TODO: 
#python3-grpcio 
#python3-grpcio-tools 
RDEPENDS:${PN} = "\
    sushi \
    python3-protobuf \
    liberation-fonts \
"

BBCLASSEXTEND = "native nativesdk"
