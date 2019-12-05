SUMMARY = "Package group for python packages needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-python-basic = "python \
    python-pip \
    python3 \
    python3-pip \
    pyliblo \
    python-alsaseq \
    python3-grpcio \
    python3-grpcio-tools \
    python3-protobuf \
    "
