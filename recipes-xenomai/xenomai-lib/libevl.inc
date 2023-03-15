SUMMARY = "Recipe for EVL core library"
SECTION = "libs/multimedia"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "ninja virtual/kernel kernel-devsrc"

SRC_URI = "\
    git://source.denx.de/Xenomai/xenomai4/libevl.git;protocol=https;nobranch=1 \
    file://evl.rules \
"

S = "${WORKDIR}/git"

EXTRA_OEMESON += "-Duapi=${STAGING_KERNEL_DIR}"
UDEV_RULES_DIR = "/etc/udev/rules.d"

inherit meson pkgconfig

do_install:append() {
    install -d ${D}${UDEV_RULES_DIR}
    install -m 0644 ${WORKDIR}/evl.rules ${D}${UDEV_RULES_DIR}
}

FILES:${PN}-dev += "/usr/tests/*"
FILES:${PN} += "${UDEV_RULES_DIR}/*"

