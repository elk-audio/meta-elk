SUMMARY = "Hackbench test utility"
HOMEPAGE = "https://wiki.linuxfoundation.org/realtime/documentation/start"
SECTION = "tests"
DEPENDS = "linux-libc-headers virtual/libc"
LICENSE = "GPL-2.0-only & GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRCREV = "4579b9a6d85ae528f76e92421eb5e7b33cd26b17"
PV = "2.5"

SRC_URI = "\
    git://git.kernel.org/pub/scm/utils/rt-tests/rt-tests.git;nobranch=1 \
    file://0001-Allow-override-for-CC-and-AR.patch \
"

S = "${WORKDIR}/git"

do_compile() {
    make hackbench PYLIB=
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hackbench ${D}${bindir}
}
