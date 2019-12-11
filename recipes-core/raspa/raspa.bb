SUMMARY = "A user space library for accessing the rtdm audio driver and device"
LICENSE = "GPLv3"

inherit cmake

SRC_URI = "gitsm://git@bitbucket.org/mindswteam/raspalib-elk.git;protocol=ssh;nobranch=1"

# NOTE: This is most likely overiden as desired from meta-<product> layer with a .bbappend recipe"
SRCREV = ""

#Note: Same as SRCREV; Overiden from meta-<product>
PV = ""
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

S = "${WORKDIR}/git"

DEPENDS = "xenomai-lib"

# Set CMAKE optimization flags
OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-staticdev"

RDEPENDS_${PN}-staticdev = ""
RDEPENDS_${PN}-dev = ""
RDEPENDS_${PN}-dbg = ""