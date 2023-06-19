SUMMARY = "Adds a custom user named "mind" with right groups membership \
            and privileges for Elk Audio OS devices"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
SECTION = "misc"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "\
    file://README \
    file://logo.sh \
    file://display-elk-logo.sh \
"

inherit useradd extrausers

### password generated with the command: openssl passwd "******"
MIND_PASSWD = "RxEA3Y8sRxpxw"
USERADD_PACKAGES = "${PN}"
HOME_DIR = "/home/mind"
USERADD_PARAM:${PN} = "-g xenomai -G audio,sudo -p '${MIND_PASSWD}' -m -d ${HOME_DIR}  -s /bin/bash mind"
GROUPADD_PARAM:${PN} = "mind; -g 2004 xenomai"
EXTRA_USERS_PARAMS = "usermod -s /bin/bash root;"

do_install() {
    install -d ${D}${HOME_DIR}
    install -m 0755 ${WORKDIR}/README ${D}${HOME_DIR}/README
    chown -R mind:mind ${D}${HOME_DIR}/
    chown mind:mind ${D}${HOME_DIR}/README

    # install elk logo display scrip
    install -d ${D}${sysconfdir}/profile.d
    install -m 0755 ${WORKDIR}/logo.sh ${D}${sysconfdir}/profile.d/logo.sh
    install -m 0755 ${WORKDIR}/display-elk-logo.sh ${D}${sysconfdir}/display-elk-logo.sh
}

FILES:${PN} = "${HOME_DIR}/*"
FILES:${PN} += "${sysconfdir}/*"

RDEPENDS:${PN} += "bash"
