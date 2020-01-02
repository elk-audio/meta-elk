#Original recipe taken as reference is from below link
#http://cgit.openembedded.org/meta-openembedded/tree/meta-networking/recipes-devtools/grpc
#version: 1.8.5
#The current recipe is ported to 1.10

SUMMARY = "A high performance, open source, general-purpose RPC framework."
DESCRIPTION = "Provides gRPC libraries for multiple languages written on top of\
 shared C core library (C++, Node.js, Python, Ruby, Objective-C, PHP, C#)"
HOMEPAGE = "https://github.com/grpc/grpc"
SECTION = "libs"

LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "\
    gflags \
    c-ares \
    protobuf \
    protobuf-native \
    protobuf-c \
    protobuf-c-native \
    openssl \
"

DEPENDS_append_class-target = "gtest grpc-native"

SRCREV = "${AUTOREV}"
BRANCH = "v1.10.x"
SRC_URI = "\
    git://github.com/grpc/grpc.git;protocol=https;branch=${BRANCH} \
    file://CMakeLists_cross_compilation_patch.patch \
    file://0001-fix-for-gettid-call.patch \
"

S = "${WORKDIR}/git"
inherit cmake

EXTRA_OECMAKE = "\
    -DgRPC_CARES_PROVIDER=package \
    -DgRPC_ZLIB_PROVIDER=package \
    -DgRPC_SSL_PROVIDER=package \
    -DgRPC_PROTOBUF_PROVIDER=package \
    -DgRPC_GFLAGS_PROVIDER=package \
    -DgRPC_INSTALL=1 \
    -DBUILD_SHARED_LIBS=ON \
    -DCMAKE_SKIP_RPATH=TRUE \
"

do_install_append() {
    install -d ${D}${libdir}
    install -m 0755 ${WORKDIR}/build/libgrpc++_reflection.so ${D}${libdir}/libgrpc++_reflection.so.1
    install -m 0755 ${WORKDIR}/build/libgrpc++.so ${D}${libdir}/libgrpc++.so.1
    rm -rf ${D}/usr/lib/cmake
}

INSANE_SKIP_grpc-dev += "dev-elf"
INSANE_SKIP_${PN} += "dev-deps"

BBCLASSEXTEND = "native"