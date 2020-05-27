SUMMARY = "A simple wrapper for controlling sushi over gRPC via a python script"
HOMEPAGE = "https://github.com/elk-audio/elkpy"
SECTION = "devel/python"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

SRC_URI = "git://github.com/elk-audio/elkpy;protocol=https;nobranch=1"
SRCREV = "0fada28313c7de04faa759822b93e53bb6e1812b"

S = "${WORKDIR}/git/"

inherit setuptools3

RDEPENDS_${PN} = "\
    sushi \
    python3-grpcio \
    python3-grpcio-tools \
    python3-protobuf \
"

BBCLASSEXTEND = "native nativesdk"