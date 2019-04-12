DESCRIPTION = "A high performance, open source, general-purpose RPC framework. \
Provides gRPC libraries for multiple languages written on top of shared C core library \
(C++, Node.js, Python, Ruby, Objective-C, PHP, C#)"
HOMEPAGE = "https://github.com/grpc/grpc"
SECTION = "libs"
LICENSE = "Apache-2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "gflags c-ares protobuf protobuf-native protobuf-c protobuf-c-native openssl"
DEPENDS_append_class-target = " gtest grpc-native"

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"
BRANCH = "v1.10.x"
SRC_URI = "git://github.com/grpc/grpc.git;protocol=https;branch=${BRANCH}"
SRC_URI += "file://CMakeLists_cross_compilation_patch.patch"

inherit cmake

BBCLASSEXTEND = "native"

EXTRA_OECMAKE = " \
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