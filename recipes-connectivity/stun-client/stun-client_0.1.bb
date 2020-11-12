# Recipe created by recipetool
# Recipe for STUN server & client
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=842bd6dd72166dfe6137cedac7ab6e9a"

SRC_URI = "git://github.com/jselbie/stunserver.git;protocol=https"

# Modify these as desired
PV = "0.1+git${SRCPV}"
SRCREV = "d2d06a6d002d1e2fba312cf4993b08bb57a0346b"

DEPENDS += "boost openssl"

S = "${WORKDIR}/git"

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/stunclient ${D}${bindir}
}

FILES_${PN} += "${bindir}*"

