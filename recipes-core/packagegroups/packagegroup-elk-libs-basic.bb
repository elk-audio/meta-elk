SUMMARY = "Basic set of libraries deployed in Elk Audio OS devices"

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
    python-libconf \
    python-io \
    grpc \
    raspa-dev \
    raspa-staticdev \
    protobuf \
"