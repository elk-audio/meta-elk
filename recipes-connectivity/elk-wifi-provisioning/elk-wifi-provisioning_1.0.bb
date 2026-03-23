SUMMARY = "BLE GATT WiFi provisioning service for Elk Audio OS"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://elk-wifi-provisioning \
    file://elk-wifi-provisioning.service \
"

S = "${WORKDIR}"

RDEPENDS:${PN} = "\
    python3-core \
    python3-json \
    python3-logging \
    python3-bluezero \
    python3-pydbus \
    python3-pygobject \
    bluez5 \
    connman \
"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "elk-wifi-provisioning.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/elk-wifi-provisioning ${D}${bindir}/elk-wifi-provisioning

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/elk-wifi-provisioning.service ${D}${systemd_system_unitdir}/
}

FILES:${PN} += "\
    ${bindir}/elk-wifi-provisioning \
    ${systemd_system_unitdir}/elk-wifi-provisioning.service \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
