SUMMARY = "An audio format Conversion library"
HOMEPAGE = "http://www.mega-nerd.com/libsndfile"
AUTHOR = "Erik de Castro Lopo"
SECTION = "libs/multimedia"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=e77fe93202736b47c07035910f47974a"

DEPENDS = "sqlite3"

PR = "r1"
SRC_URI = "http://www.mega-nerd.com/libsndfile/files/libsndfile-${PV}.tar.gz;name=libsndfile1021targz"
SRC_URI[libsndfile1021targz.md5sum] = "880a40ec636ab2185b97f8927299b292"
SRC_URI[libsndfile1021targz.sha256sum] = "7e9083a2551ff347276d82cdb61f2b4f9cd137c0b76433800e991583ded8ea67"

S = "${WORKDIR}/libsndfile-${PV}"

inherit autotools  lib_package pkgconfig

do_configure_prepend_arm() {
    ac_cv_sizeof_off_t=8
    # they are not in one of site/ files because they are common with
    # glib-2.0 if they are moved to common site files then they break
    # glib-2.0 build if largefile support is not available (.e.g. uclibc
    # can be tuned to not have it.
    export ac_cv_sys_largefile_source=1
    export ac_cv_sys_file_offset_bits=64
}

do_configure_prepend_chinook-compat () {
    for i in  lt~obsolete.m4 ltsugar.m4 libtool.m4 ltoptions.m4 ltversion.m4
    do
            rm ${S}/M4/${i}
    done
}

PACKAGES =+ "${PN}-octave"

FILES_${PN}-octave += "/usr/share/octave/site/m"