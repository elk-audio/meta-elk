SUMMARY = "Package group for python packages needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-python-extended = "python3-six \
    python3-setuptools \
    python3-pyftdi \
    python3-smbus2 \
    python3-luma-core \
    python3-luma-oled \
    "
