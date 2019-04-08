SUMMARY = "Package group for libraries needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-libs = "xenomai-lib \
    alsa-utils \
    libstdc++ \
    liblo \
    libsndfile1 \
    jsoncpp \
    libserialport \
    bluez5 \
    twine \
    twine-dev \
    python-libconf \
    python-io"