DESCRIPTION = "All custom systemd services for ELK upcore"
LICENSE = "CLOSED"
PR = "r0"
PN = "elk-systemd-services"
PV = "0.1"
S = "${WORKDIR}"

PACKAGE_ARCH = "all"

inherit systemd

FILES_${PN} += "${systemd_system_unitdir}/*"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

#FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://load-drivers.service \
        file://rfkill-atboot.service \
        file://custom-elk.target"

do_install () {

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/load-drivers.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/rfkill-atboot.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/custom-elk.target ${D}${systemd_system_unitdir}/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "load-drivers.service \
                        rfkill-atboot.service"

SYSTEMD_AUTO_ENABLE = "enable"
