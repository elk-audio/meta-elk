SUMMARY = "Package group for libraries needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-libs-basic = "libjack \
    jack-server \
    jack-utils \
    stk \
    csound \
    libsndfile1 \
    libserialport \
    bluez5 \
    "
