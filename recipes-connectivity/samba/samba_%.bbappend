FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += " file://custom-smb.conf"

do_install_append() {
    install -m 0644 ${WORKDIR}/custom-smb.conf ${D}${sysconfdir}/samba/smb.conf
}