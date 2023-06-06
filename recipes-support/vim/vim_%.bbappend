# Vim append
# Add custom vimrc configuration

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://custom_vimrc"

do_install:append() {
    install -m 0644 ${WORKDIR}/custom_vimrc ${D}${datadir}/${BPN}/vimrc
}
