SUMMARY = "RaveloxMIDI recipe for RTP midi"
HOMEPAGE = "https://github.com/ravelox/pimidi"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=d41d8cd98f00b204e9800998ecf8427e"

SRC_URI = "git://github.com/ravelox/pimidi.git;protocol=https"
SRC_URI += "file://0001-patch-for-autotools.patch"

SRCREV = "7d361543dc16bfece80e1d36063ec22f875a11d1"

S = "${WORKDIR}/git/raveloxmidi"

DEPENDS = "avahi alsa-lib"

inherit autotools pkgconfig

do_patch(){
   cd ${WORKDIR}/git
   patch -p1 < ${WORKDIR}/0001-patch-for-autotools.patch
}

do_configure:prepend(){
    cd ${S}
    ./autogen.sh
}

do_configure:append(){
    echo "#define HAVE_ALSA 1" >> ${S}/config.h
}

do_compile:prepend(){
    cd ${S}
}

do_install:prepend(){
    cd ${S}
}

FILES:${PN} = "${bindir}/*"

