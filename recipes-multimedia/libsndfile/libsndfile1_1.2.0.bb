SUMMARY = "Audio format Conversion library"
DESCRIPTION = "Library for reading and writing files containing sampled \
sound (such as MS Windows WAV and the Apple/SGI AIFF format) through \
one standard library interface."
HOMEPAGE = "https://libsndfile.github.io/libsndfile/"
AUTHOR = "Erik de Castro Lopo"
DEPENDS = "flac libogg libvorbis"
SECTION = "libs/multimedia"
LICENSE = "LGPL-2.1-only"

SRC_URI = "\
    gitsm://github.com/libsndfile/libsndfile.git;protocol=https;nobranch=1 \
"
SRC_URI[sha256sum] = "75c4813917b53990c5ca3117d6bedb3f95bf5f656def1129514c0d92b28d40ed"
SRCREV = "2ed38b57c5838ba6b7c8e726a62855845bd42ec5"

LIC_FILES_CHKSUM = "file://COPYING;md5=e77fe93202736b47c07035910f47974a"

CVE_PRODUCT = "libsndfile"

EXTRA_OECMAKE += "\
    -DCMAKE_INSTALL_LIBDIR=lib \
    -DCMAKE_INSTALL_PREFIX=/usr \
    -DENABLE_PACKAGE_CONFIG=ON \
    -DINSTALL_PKGCONFIG_MODULE=ON \
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_EXAMPLES=OFF \
    -DBUILD_PROGRAMS=OFF \
    -DBUILD_TESTING=OFF \
    -DINSTALL_MANPAGES=OFF \
    -DENABLE_MPEG=OFF \
    -DENABLE_EXTERNAL_LIBS=OFF \
"

S = "${WORKDIR}/git"

inherit cmake
