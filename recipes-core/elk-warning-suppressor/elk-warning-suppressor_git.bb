SUMMARY = "Elk Warning Suppressor"
DESCRIPTION = "Support library for suppressing warnings in included 3rd party code"
HOMEPAGE = "https://github.com/elk-audio/elk-warning-suppressor"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"
DEPENDS = ""
# SRCREV should be mentioned in the product layer as it will be specific to that.
SRCREV = "56dc1d4a30519c8a33fde567adbbe3719878aceb"
# The specific version should be overidden in the meta-product layers
PV = "0.1.0"

SRC_URI = "gitsm://github.com/elk-audio/elk-warning-suppressor;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

inherit cmake
