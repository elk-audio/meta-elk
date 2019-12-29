SUMMARY = "Extended system packages deployed in Elk Audio OS devices"

inherit packagegroup

RDEPENDS_packagegroup-elk-system-extended = "\
    zsh \
    ldd \
    i2c-tools \
    iproute2-tc \
"