# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Python bindings for the liblo OSC library"
HOMEPAGE = "http://das.nasophon.de/pyliblo/"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
# NOTE: Original package / source metadata indicates license is: LGPL
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "LGPLv2.1 & LGPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"
PV = "0.10.0"

SRC_URI = "http://das.nasophon.de/download/pyliblo-${PV}.tar.gz"
SRC_URI[md5sum] = "1be68794dedaf8cc60748fe94fdb9628"
SRC_URI[sha256sum] = "fc67f1950b827272b00f9f0dc4ed7113c0ccef0c1c09e9976dead40ebbf1798f"

inherit setuptools3
DEPENDS += "liblo python3-cython python3-cython-native"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS_${PN} += "python3-core"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    liblo