SUMMARY = "A simple wrapper for controlling sushi over gRPC via a python script"
HOMEPAGE = "https://github.com/elk-audio/elkpy"
SECTION = "devel/python"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

SRC_URI = "git://github.com/elk-audio/elkpy;protocol=https;nobranch=1"
SRCREV = "8a15df83e199fb1eb8f2aa022fc6383211bd7ceb"

S = "${WORKDIR}/git"

inherit setuptools3

RDEPENDS:${PN} = "\
    sushi \
    python3-grpcio \
    python3-grpcio-tools \
    python3-protobuf \
    liberation-fonts \
"
do_install:append(){
    rm -r ${D}${PYTHON_SITEPACKAGES_DIR}/tests
}

BBCLASSEXTEND = "native nativesdk"
