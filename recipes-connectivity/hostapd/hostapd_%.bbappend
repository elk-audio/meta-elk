# hostapd append
# Add Elk Audio OS specific configuration changes to hostapd

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
# Hostapd is disabled by default
# SYSTEMD_AUTO_ENABLE:${PN} = "enable"

SRC_URI += "\
    file://hostapd-elk.conf \
    file://hostapd.service \
"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/hostapd-elk.conf ${D}${sysconfdir}/hostapd.conf
    install -m 0644 ${UNPACKDIR}/hostapd.service ${D}${systemd_system_unitdir}/
}
