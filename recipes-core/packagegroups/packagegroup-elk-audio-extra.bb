SUMMARY = "Extra audio libraries needed for some specific use cases"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

RDEPENDS_packagegroup-elk-audio-extra = "\
    libjack \
    jack-server \
    jack-utils \
    stk \
    csound \
    fluidsynth \
    lv2 \
    sord \
    serd \
    sratom \
    lilv \
"