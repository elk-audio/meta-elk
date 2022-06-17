SUMMARY = "User-space driver for modern FTDI devices, implemented in pure Python language."
HOMEPAGE = "https://github.com/eblot/pyftdi"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS += "${PYTHON_PN}-protobuf"

inherit pypi setuptools3

SRC_URI += "file://0001-Patch-to-fix-the-cc-variables.patch"
SRC_URI[sha256sum] = "e8f2f5d16e0164c415f1b31a8d9a81f2e4645a43d1b261375d6bab7b0adf511f"

RDEPENDS:${PN} = "${PYTHON_PN}-protobuf \
                  ${PYTHON_PN}-setuptools \
                  ${PYTHON_PN}-six \
"

