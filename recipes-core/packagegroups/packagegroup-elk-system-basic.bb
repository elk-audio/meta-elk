SUMMARY = "Basic system packages deployed in Elk Audio OS devices"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

RDEPENDS_packagegroup-elk-system-basic = " \
    kernel-modules \
    custom-user \
    elk-systemd-services \
    bash \
    connman \
    avahi-daemon \
"
