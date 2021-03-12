# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d21c96584427f10166aee1daeae1e332"

SRC_URI = "git://github.com/angeloc/htpdate.git;protocol=https"

inherit pkgconfig

# Modify these as desired
PV = "0.1+git${SRCPV}"
SRCREV = "86eb1aec3169a4b81fdf160de9ce6a437e5e881c"

S = "${WORKDIR}/git"

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
	install -d ${bindir}
	oe_runmake install 'DESTDIR=${D}'
}

FILES_${PN} = "${bindir}/*"
INSANE_SKIP_${PN} += "already-stripped"

