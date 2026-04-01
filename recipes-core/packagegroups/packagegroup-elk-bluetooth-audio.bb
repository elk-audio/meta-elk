SUMMARY = "Bluetooth audio streaming stack (PipeWire + WirePlumber + BlueZ5)"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    bluez5 \
    elk-bluetooth-agent \
    pipewire \
    wireplumber \
    pipewire-spa-plugins-bluez5 \
    pipewire-tools \
"
