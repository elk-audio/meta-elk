SUMARRY = "Xenomai real time core and supporting libraries"
DESCRIPTION = "Provides userspace xenomai support and libraries needed to for \
real-time applications using the xenomai RTOS implementation (3.0.8)"
HOMEPAGE = "https://gitlab.denx.de/Xenomai/xenomai/wikis/Start_Here"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "\
    file://debian/copyright;md5=b845d61ada88e4a5e0df2b2b74272db7 \
    file://kernel/cobalt/COPYING;md5=073dc31ccb2ebed70db54f1e8aeb4c33 \
    file://kernel/cobalt/rtdm/COPYING;md5=c99f6e66e37d1cb50ad8be4f5be2ea5d \
    file://kernel/cobalt/posix/COPYING;md5=073dc31ccb2ebed70db54f1e8aeb4c33 \
    file://lib/trank/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
    file://lib/copperplate/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
    file://lib/vxworks/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
    file://lib/cobalt/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
    file://lib/smokey/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
    file://lib/psos/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
    file://lib/alchemy/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
    file://lib/analogy/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
    file://lib/boilerplate/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
    file://lib/boilerplate/iniparser/LICENSE;md5=124f16654dec67923ad76a803e102463 \
    file://include/COPYING;md5=79ed705ccb9481bf9e7026b99f4e2b0e \
"

SRC_URI = "\
    git://source.denx.de/Xenomai/xenomai;protocol=https;nobranch=1 \
    file://rtdm.rules \
"

# Tag v3.2.2
SRCREV = "92edb496f7e8a51f986760982bfef2051ff60e9b"

S = "${WORKDIR}/git"

inherit pkgconfig autotools

prefix = "/usr/xenomai"
UDEV_RULES_DIR = "/etc/udev/rules.d"

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--enable-smp --with-core=cobalt"

do_install:append() {
    install -d ${D}${UDEV_RULES_DIR}
    install -m 0644 ${WORKDIR}/rtdm.rules ${D}${UDEV_RULES_DIR}

    # xenomai installs rtp device. We do not want that in the image as its only
    # needed for some tests
    rm -rf ${D}/dev
}

FILES:${PN} += "/usr/xenomai/lib/*"
FILES:${PN} += "usr/xenomai/demo/*"
FILES:${PN} += "usr/xenomai/share/*"
FILES:${PN} += "${UDEV_RULES_DIR}/*"

INSANE_SKIP:${PN} += "ldflags"
