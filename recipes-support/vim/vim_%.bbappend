SUMMARY = "Adds custom vimrc config file"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://custom_vimrc"

do_install_append() {
    install -m 0644 ${WORKDIR}/custom_vimrc ${D}${datadir}/${BPN}/vimrc
}