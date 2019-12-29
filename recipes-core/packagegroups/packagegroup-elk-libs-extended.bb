SUMMARY = "Extended set of libraries deployed in Elk Audio OS devices"

inherit packagegroup

RDEPENDS_packagegroup-elk-libs-extended = "\
    libjack \
    jack-server \
    jack-utils \
    stk \
    csound \
    libsndfile1 \
    libserialport \
    bluez5 \
"