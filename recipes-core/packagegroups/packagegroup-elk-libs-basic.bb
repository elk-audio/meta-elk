SUMMARY = "Basic set of libraries deployed in Elk Audio OS devices"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

RDEPENDS_packagegroup-elk-libs-basic = "\
    xenomai-lib \
    alsa-utils \
    libstdc++ \
    libstdc++-staticdev \
    liblo \
    jsoncpp \
    twine \
    twine-dev \
    python3-libconf \
    python3-io \
    grpc \
    raspa-dev \
    raspa-staticdev \
    protobuf-dev \
    miniupnp-client \
    freetype \
"
