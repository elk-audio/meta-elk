SUMMARY = "An audio format Conversion library"
HOMEPAGE = "http://www.mega-nerd.com/libsndfile"
AUTHOR = "Erik de Castro Lopo"
SECTION = "libs/multimedia"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=e77fe93202736b47c07035910f47974a"

PR = "r2"
SRC_URI = "http://www.mega-nerd.com/libsndfile/libsndfile-${PV}.tar.gz"
SRC_URI[md5sum] = "773b6639672d39b6342030c7fd1e9719"
SRC_URI[sha256sum] = "79e305112a4d9598b93b614a7747604f9ef10d9a2dee52c5903b554bbeaedd7c"

S = "${WORKDIR}/libsndfile-${PV}"

inherit autotools lib_package pkgconfig

do_stage() {
    oe_libinstall -a -so -C src libsndfile ${STAGING_LIBDIR}
    install -m 0644 ${S}/src/sndfile.h ${STAGING_INCDIR}/
}