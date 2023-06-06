# Samba append
# Add custom samba configuration

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += " file://custom-smb.conf"

do_install:append() {
    install -m 0644 ${WORKDIR}/custom-smb.conf ${D}${sysconfdir}/samba/smb.conf
}
