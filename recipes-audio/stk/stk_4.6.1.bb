SUMMARY = "The Synthesis ToolKit in C++"
HOMEPAGE = "https://ccrma.stanford.edu/software/stk/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db6cb276e2d0659d53f51cbd97807afc"

SRC_URI = "\
    http://ccrma.stanford.edu/software/stk/release/${BPN}-${PV}.tar.gz \
    file://0001-avoid-usr-usr-paths.patch \
    file://0002-configure.ac-fix-shared-library-name.patch \
"
SRC_URI[md5sum] = "4a07cd00bf264fa8488ba0fce9a59a3f"
SRC_URI[sha256sum] = "e77ba3c80cdd93ca02c34098b9b7f918df3d648c87f1ed5d94fe854debd6d101"

inherit autotools-brokensep pkgconfig

DISABLE_STATIC = ""
DEPENDS = "alsa-utils"
EXTRA_OECONF = "--enable-realtime --without-alsa --without-jack"

TARGET_CFLAGS += " -O3"
TARGET_CXXFLAGS += " -O3"