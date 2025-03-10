SUMMARY = "Realtime MIDI I/O for Python on Windows, OS X, and Linux."
HOMEPAGE = "https://github.com/patrickkidd/pyrtmidi"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "alsa-lib"

SRC_URI[md5sum] = "01434c449e94f92040bcb90d789dcf40"
SRC_URI[sha256sum] = "bc1e40c24f7df052df9b1e586b82a6987f899ae1a8596ec682af662df275e9b0"

inherit pypi setuptools3

PYPI_PACKAGE = "rtmidi"
