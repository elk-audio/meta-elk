SUMMARY = "User space applications in Elk Audio OS devices"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

# Sensei was removed from this list since it is not currently supported
# on EVL based images because underlying driver is not implemented.
RDEPENDS:packagegroup-elk-applications = "\
    sushi \
"
