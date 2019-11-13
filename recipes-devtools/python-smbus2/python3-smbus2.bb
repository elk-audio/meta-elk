SUMMARY = "A drop-in replacement for smbus-cffi/smbus-python in pure Python"
HOMEPAGE = "https://github.com/kplindegaard/smbus2"
LICENSE = "MIT"
SECTION = "devel/python"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pypi setuptools3

PV = "0.3.0"
SRC_URI[md5sum] = "d5ed5acc889b4770a84cc932853ed20a"
SRC_URI[sha256sum] = "210e66eebe4d0b1fe836b3ec2751841942e1c4918c0b429b20a0e20a222228b4"

PYPI_PACKAGE = "smbus2"

inherit pypi setuptools3