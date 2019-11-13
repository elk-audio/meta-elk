SUMMARY = "Package group for python packages needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-python-pkgs = "python \
    python-pip \
    python3 \
    python3-pip \
    python3-six \
    pyliblo \
    python3-setuptools \
    python-alsaseq \
    python3-grpcio \
    python3-grpcio-tools \
    python3-protobuf \
    python3-pyftdi \
    python3-smbus2 \
    python3-luma-core \
    python3-luma-oled \
    "
