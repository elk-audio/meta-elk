SUMMARY = "Extended python packages deployed in Elk Audio OS devices"

inherit packagegroup

RDEPENDS_packagegroup-elk-python-extended = "\
    python3-six \
    python3-setuptools \
    python3-pyftdi \
    python3-smbus2 \
"