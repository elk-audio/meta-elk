SUMMARY = "Package group for system packages needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-system-extended = " \
    zsh \
    ldd \
    i2c-tools \
    iproute2-tc \
    "
