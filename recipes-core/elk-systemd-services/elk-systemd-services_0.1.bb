SUMMARY = "All custom systemd services for ELK Audio OS systems"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

PR = "r0"
PN = "elk-systemd-services"
PV = "0.1"

SRC_URI += "\
    file://custom-elk.target \
    file://var-lib-overlay.service \
"

S = "${WORKDIR}"

inherit systemd

PACKAGE_ARCH = "${MACHINE_ARCH}"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/custom-elk.target ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/var-lib-overlay.service ${D}${systemd_system_unitdir}/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} += "var-lib-overlay.service"

SYSTEMD_AUTO_ENABLE = "enable"

FILES_${PN} += "${systemd_system_unitdir}/*"
