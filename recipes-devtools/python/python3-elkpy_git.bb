SUMMARY = "A simple wrapper for controlling sushi over gRPC via a python script"
HOMEPAGE = "https://github.com/elk-audio/elkpy"
SECTION = "devel/python"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

SRCREV = "ea5827e691848f352f0734025add848765d6fb91"

PV = "1.4.0"

SRC_URI = "gitsm://github.com/elk-audio/elkpy;protocol=https;nobranch=1"

S = "${WORKDIR}/git"

inherit python_setuptools_build_meta

# Usually this is handled by setuptools and (something else?). but the files
# seem to be missing in the rootfs when do_install is completed.
do_install:append() {
    cp -r ${S}/src/elkpy ${D}${PYTHON_SITEPACKAGES_DIR}/.
}

RDEPENDS:${PN} = "\
    sushi \
    python3-protobuf \
    liberation-fonts \
    python3-grpcio \
    python3-grpcio-tools \
    python3-pyzmq \
    zeromq \
"

DEPENDS += "\
    python3-pyzmq \
    zeromq \
"

FILES:${PN}:append = "\
    ${PYTHON_SITEPACKAGES_DIR}/elkpy \
"

BBCLASSEXTEND = "native nativesdk"
