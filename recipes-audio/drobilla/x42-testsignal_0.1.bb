LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/x42/testsignal.lv2.git;protocol=https;branch=master"

# Modify these as desired
PV = "0.1+git${SRCPV}"
SRCREV = "a4bd7f86c3773c6fa23e4eca2683654db52804de"

inherit pkgconfig
DEPENDS = "lv2"

S = "${WORKDIR}/git"

do_configure () {
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
	oe_runmake install 'DESTDIR=${D}' 'PREFIX=/usr'
}

FILES:${PN} += "${libdir}/lv2/*"
INSANE_SKIP:${PN} += "already-stripped"

