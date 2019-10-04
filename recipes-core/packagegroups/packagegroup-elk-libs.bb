SUMMARY = "Package group for libraries needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-libs = "xenomai-lib \
    alsa-utils \
    libjack \
    jack-server \
    jack-utils \
    stk \
    csound \
    libstdc++ \
    libstdc++-staticdev \
    liblo \
    libsndfile1 \
    jsoncpp \
    libserialport \
    bluez5 \
    twine \
    twine-dev \
    python-libconf \
    python-io \
    grpc \
    protobuf \
    "
