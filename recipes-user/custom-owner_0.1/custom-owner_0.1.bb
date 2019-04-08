DESCRIPTION = "Adds a custom owner along with home files"
SECTION = "misc"
LICENSE = "CLOSED"

HOME_DIR = "/home/mind"

inherit useradd extrausers

### password generated with the command: openssl passwd "******"
MIND_PASSWD = "RxEA3Y8sRxpxw"

USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "-g xenomai -G audio -p '${MIND_PASSWD}' -m -d ${HOME_DIR} mind"
GROUPADD_PARAM_${PN} = "mind; -g 2004 xenomai"

SRC_URI = "file://README"

do_install() {

  install -d ${D}${HOME_DIR}
  install -m 0755 ${WORKDIR}/README ${D}${HOME_DIR}/README
  chown -R mind:mind ${D}${HOME_DIR}/
  chown mind:mind ${D}${HOME_DIR}/README
}

FILES_${PN} = "${HOME_DIR}/*"