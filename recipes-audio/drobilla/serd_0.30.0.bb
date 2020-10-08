SUMMARY = "C library for RDF syntax which supports accessing Turtle and NTriples"
HOMEPAGE = "http://drobilla.net/software/serd"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=7aceb3a3edc99517b08f5cdd557e11fb"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

S = "${WORKDIR}/git"

SRCREV = "45f0b7c3a042d42aeee3263e84d61e3a55809763"
SRC_URI = "git://github.com/drobilla/serd.git;protocol=https;nobranch=1"
SRC_URI += "file://0001-Fix-for-python3-migration-in-yocto.patch"

inherit waf

do_configure_prepend(){
    sed -i 's/python/python3/' ${S}/waf
}
