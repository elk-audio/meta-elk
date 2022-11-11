SUMMARY = "A simple wrapper for controlling sushi over gRPC via C++."
HOMEPAGE = "https://github.com/elk-audio/elkcpp"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

DEPENDS = "\
    sushi \
    grpc \
    grpc-native \
    protobuf \
    protobuf-native \
    protobuf-c \
    protobuf-c-native\
"

SRC_URI = "gitsm://github.com/elk-audio/elkcpp;protocol=https;nobranch=1"
SRCREV = "83d6d002246a25223113c65327ec44a275211e26"

S = "${WORKDIR}/git"

inherit cmake

# Set CMAKE optimization flags
OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"

# This is installed in the sysroot by sushi
SUSHI_PROTO_FILE_PATH = "${STAGING_DATADIR}/sushi/sushi_rpc.proto"

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DPROTO_FILE_PATH=${SUSHI_PROTO_FILE_PATH} \
    -DGRPC_WRAPPER_BUILD_EXAMPLES=FALSE \
    -DGRPC_WRAPPER_RUN_TESTS=FALSE \
    -DPRINT_ERRORS_TO_CONSOLE=FALSE \
"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev"

RDEPENDS:${PN}-staticdev = ""
RDEPENDS:${PN}-dev = ""
RDEPENDS:${PN}-dbg = ""
