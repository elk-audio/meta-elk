SUMMARY = "Google gRPC framework"
HOMEPAGE = "http://www.grpc.io/"
SECTION = "devel/python"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS += "${PYTHON_PN}-protobuf"

SRC_URI[md5sum] = "2332bd45ac67edcb076ce291f2ad55de"
SRC_URI[sha256sum] = "41bf456665d666d0a07cb1b363626745dc1a98b02395acd666b36c929133a72a"

FILESEXTRAPATHS_prepend := "${THISDIR}/python-grpcio:"
SRC_URI_append_class-target = "\
    file://0001-setup.py-Do-not-mix-C-and-C-compiler-options.patch\
    file://gettid.patch\
"

inherit pypi

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-protobuf \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-six \
"

CLEANBROKEN = "1"

BBCLASSEXTEND = "native nativesdk"
