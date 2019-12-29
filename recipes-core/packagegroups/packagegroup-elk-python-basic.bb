SUMMARY = "Basic python packages deployed in Elk Audio OS devices"

inherit packagegroup

RDEPENDS_packagegroup-elk-python-basic = "\
    python \
    python-pip \
    python3 \
    python3-pip \
    pyliblo \
    python-alsaseq \
    python3-grpcio \
    python3-grpcio-tools \
    python3-protobuf \
"