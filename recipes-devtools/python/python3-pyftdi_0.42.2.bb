SUMMARY = "User-space driver for modern FTDI devices, implemented in pure Python language."
HOMEPAGE = "https://github.com/eblot/pyftdi"
SECTION = "devel/python"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

PV = "0.30.3"
SRC_URI[md5sum] = "fc38cc4ce0f1ffb4b700377b448d32a3"
SRC_URI[sha256sum] = "ed55f0cb2d2f84b6e97be9583d582480ba9777cb0179aac0bb0ac480cd6760f5"

PYPI_PACKAGE = "pyftdi"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-pyusb \
    ${PYTHON_PN}-pyserial \
"