SUMMARY = "Htpdate utility"
DESCRIPTION = "The HTTP Time Protocol (HTP) is used to synchronize a computer's time \
    with web servers as reference time source. Htpdate will synchronize your computer's time \
    by extracting timestamps from HTTP headers found in web server responses. \
    Htpdate can be used as a daemon, to keep your computer synchronized. \
    The accuracy of htpdate is at least -+0.5 seconds (better with multiple servers)."
HOMEPAGE = "https://github.com/angeloc/htpdate"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d21c96584427f10166aee1daeae1e332"

SRC_URI = "git://github.com/angeloc/htpdate.git;protocol=https;branch=master"

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

FILES:${PN} = "${bindir}/*"
INSANE_SKIP:${PN} += "already-stripped"
