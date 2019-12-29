SUMMARY = "Elk Audio OS specific configuration changes to hostapd"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
# Hostapd is disabled by default
# SYSTEMD_AUTO_ENABLE_${PN} = "enable"

SRC_URI += "\
    file://hostapd-elk.conf \
    file://hostapd.service \
"

do_install_append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/hostapd-elk.conf ${D}${sysconfdir}/hostapd.conf
    install -m 0644 ${WORKDIR}/hostapd.service ${D}${systemd_system_unitdir}/
}