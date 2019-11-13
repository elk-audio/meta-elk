SUMMARY = "Python module which contain the display drivers for some OLED screens"
HOMEPAGE = "https://github.com/rm-hull/luma.oled"
LICENSE = "MIT"
SECTION = "devel/python"

LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=ce5fd4861bb9fba0391b38773ee34c53"

inherit pypi setuptools3

PV = "3.3.0"
SRC_URI[md5sum] = "bcf056a04f3f6ffc940cda479ebb387e"
SRC_URI[sha256sum] = "4bc9f169c4342bc5b49b9a500fbc9e2d9f95de65e07fc2016e1631e08e0da694"

SRC_URI += "file://demo_opts.py"

PYPI_PACKAGE = "luma.oled"

inherit pypi setuptools3

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-pillow \
    ${PYTHON_PN}-pyserial \
    ${PYTHON_PN}-pyusb \
    ${PYTHON_PN}-spidev \
    rpi-gpio \
    ${PYTHON_PN}-pyftdi \
    ${PYTHON_PN}-smbus2 \
    ${PYTHON_PN}-luma-core \
    "

do_install_append() {
    cp ${WORKDIR}/demo_opts.py ${D}${PYTHON_SITEPACKAGES_DIR}
}

FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}/demo_opts.py"