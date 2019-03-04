# Recipe created by recipetool

SUMMARY = "libconf implementation for Python"
HOMEPAGE = "https://github.com/Grk0/python-libconf"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=05f696c084eaaf5d75bc150f70975758"

SRC_URI = "git://github.com/Grk0/python-libconf.git;protocol=https"

# Modify these as desired
PV = "0..1.0+git${SRCPV}"
SRCREV = "be0b04abd486159afcfadd24dd303e5a2a1c431a"

S = "${WORKDIR}/git"

inherit setuptools

do_install_append() {
}

