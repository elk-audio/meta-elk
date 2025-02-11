SUMMARY = "All custom systemd services for ELK Audio OS systems"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PV = "0.1"
PR = "r0"

SRC_URI += "\
    file://custom-elk.target \
    file://var-lib-overlay.service \
    ${@bb.utils.contains('DISTRO_FEATURES', 'user-autostart-service', 'file://user-autostart.service', '', d)} \
"

S = "${WORKDIR}"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} += " \
    var-lib-overlay.service \
    ${@bb.utils.contains('DISTRO_FEATURES', 'user-autostart-service', 'user-autostart.service', '', d)} \
"
SYSTEMD_AUTO_ENABLE = "enable"

inherit systemd
inherit features_check

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/custom-elk.target ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/var-lib-overlay.service ${D}${systemd_system_unitdir}/
    if ${@bb.utils.contains('DISTRO_FEATURES', 'user-autostart-service', 'true', 'false', d)}; then
        install -m 0644 ${WORKDIR}/user-autostart.service ${D}${systemd_system_unitdir}/
    fi
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES:${PN} += "${systemd_system_unitdir}/*"

PN = "elk-systemd-services"
REQUIRED_DISTRO_FEATURES += "systemd"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
NATIVE_SYSTEMD_SUPPORT = "1"
