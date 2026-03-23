SUMMARY = "BlueZ auto-pairing agent for headless Bluetooth audio on Elk Audio OS"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://elk-bluetooth-agent \
    file://elk-bluetooth-agent.service \
    file://pipewire_bridge.conf \
"

S = "${WORKDIR}"

RDEPENDS:${PN} = "\
    python3-core \
    python3-dbus \
    python3-pygobject \
    bluez5 \
"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "elk-bluetooth-agent.service"
SYSTEMD_AUTO_ENABLE = "disable"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/elk-bluetooth-agent ${D}${bindir}/elk-bluetooth-agent

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/elk-bluetooth-agent.service ${D}${systemd_system_unitdir}/

    install -d ${D}${sysconfdir}/raspa
    install -m 0644 ${WORKDIR}/pipewire_bridge.conf ${D}${sysconfdir}/raspa/
}

FILES:${PN} += "\
    ${bindir}/elk-bluetooth-agent \
    ${systemd_system_unitdir}/elk-bluetooth-agent.service \
    ${sysconfdir}/raspa/pipewire_bridge.conf \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
