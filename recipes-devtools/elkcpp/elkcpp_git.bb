SUMMARY = "A simple wrapper for controlling sushi over gRPC via C++."
HOMEPAGE = "https://github.com/elk-audio/elkcpp"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

DEPENDS = "\
    grpc \
    grpc-native \
    protobuf \
    protobuf-native \
    protobuf-c \
    protobuf-c-native\
"

SRCREV = "4a7d6e968d29ed408b281bafb5d737cc60e97821"

SRC_URI = "gitsm://github.com/elk-audio/elkcpp;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

inherit cmake

# gRPCConfig.cmake skips gRPCPluginTargets.cmake when CMAKE_CROSSCOMPILING=TRUE,
# so gRPC::grpc_cpp_plugin is undefined. Inject it from the native sysroot via
# CMAKE_PROJECT_INCLUDE (processed just after project(), before find_package).
do_configure:prepend() {
    cat > ${WORKDIR}/inject-grpc-native-plugin.cmake << EOF
# Inject native gRPC plugin target for cross-compilation.
# gRPCConfig.cmake guards gRPCPluginTargets.cmake with if(NOT CMAKE_CROSSCOMPILING),
# so gRPC::grpc_cpp_plugin is undefined in cross builds.
include("${STAGING_LIBDIR_NATIVE}/cmake/grpc/gRPCPluginTargets.cmake")

# Inject native protoc target for cross-compilation.
# The target sysroot's protobuf-targets.cmake omits protobuf::protoc (host tool);
# without it protobuf_generate() emits the literal string "protobuf::protoc" as the
# command, which fails at build time.
if(NOT TARGET protobuf::protoc)
    add_executable(protobuf::protoc IMPORTED GLOBAL)
    set_target_properties(protobuf::protoc PROPERTIES
        IMPORTED_LOCATION "${STAGING_BINDIR_NATIVE}/protoc"
    )
endif()
EOF
}

EXTRA_OECMAKE += "\
    -DCMAKE_BUILD_TYPE=Release \
    -DGRPC_WRAPPER_BUILD_EXAMPLES=FALSE \
    -DGRPC_WRAPPER_RUN_TESTS=FALSE \
    -DPRINT_ERRORS_TO_CONSOLE=FALSE \
    -DCMAKE_PROJECT_INCLUDE=${WORKDIR}/inject-grpc-native-plugin.cmake \
"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev"

RDEPENDS:${PN}-staticdev = ""
RDEPENDS:${PN}-dev = ""
RDEPENDS:${PN}-dbg = ""

# Set CMAKE optimization flags
OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"
