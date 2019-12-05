SUMMARY = "Package group for libraries needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-libs-basic = "xenomai-lib \
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
    protobuf \
    "
