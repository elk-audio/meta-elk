SUMMARY = "Image testing utilities."
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

RDEPENDS:packagegroup-elk-image-testing = "\
    raspa-test-apps \
    stress-ng \
    hackbench \
"
