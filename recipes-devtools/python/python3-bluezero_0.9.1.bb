SUMMARY = "A Python library for Bluetooth Low Energy (BLE) using the BlueZ DBus API"
HOMEPAGE = "https://github.com/ukBaz/python-bluezero"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[sha256sum] = "82488a9dc264f6114bb9727cc7e8939fa3a8d08fd71384cdab31419a80d25f97"

inherit pypi setuptools3

PYPI_PACKAGE = "bluezero"

RDEPENDS:${PN} = "\
    python3-dbus \
    python3-pygobject \
    bluez5 \
"
