SUMMARY = "Basic development tools deployed in Elk Audio OS devices"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

RDEPENDS_packagegroup-elk-devtools-basic = "\
    util-linux \
    packagegroup-core-buildessential \
    vim \
    cmake \
    nano \
"