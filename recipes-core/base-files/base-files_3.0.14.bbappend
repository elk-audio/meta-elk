FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://dot.profile \
            file://fstab"

UDATA_DIR = "/udata"
do_install_append() {
    install -d ${D}${UDATA_DIR}
    install -m 0755 ${WORKDIR}/dot.profile ${D}${sysconfdir}/skel/.profile
    install -m 0755 ${WORKDIR}/fstab ${D}${sysconfdir}/fstab
}

FILES_${PN} += "${UDATA_DIR}"
