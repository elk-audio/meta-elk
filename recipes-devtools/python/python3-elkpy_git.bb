SUMMARY = "A simple wrapper for controlling sushi over gRPC via a python script"
HOMEPAGE = "https://github.com/elk-audio/elkpy"
SECTION = "devel/python"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

SRC_URI = "git://github.com/elk-audio/elkpy;protocol=https;nobranch=1"
SRCREV = "a81443bc263498ee36cff22e1824cb7ff33f2b57"

S = "${WORKDIR}/git/"

inherit setuptools3

RDEPENDS_${PN} = "\
    sushi \
    python3-grpcio \
    python3-grpcio-tools \
    python3-protobuf \
"

BBCLASSEXTEND = "native nativesdk"
