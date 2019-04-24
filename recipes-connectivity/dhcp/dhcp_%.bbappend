FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://dhcpd-elk.conf \
            file://default-server-elk \
            file://dhcpd-elk.service"

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_AUTO_ENABLE_${PN}-server = "enable"

do_install_append() {
    install -m 0644 ${WORKDIR}/dhcpd-elk.service ${D}${systemd_unitdir}/system/dhcpd.service
    install -m 0644 ${WORKDIR}/dhcpd-elk.conf ${D}${sysconfdir}/dhcp/dhcpd.conf
    install -m 0644 ${WORKDIR}/default-server-elk ${D}${sysconfdir}/default/dhcp-server
}