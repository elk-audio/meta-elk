SUMMARY = "Basic system packages deployed in Elk Audio OS devices"

inherit packagegroup

RDEPENDS_packagegroup-elk-system-basic = " \
    kernel-modules \
    custom-owner \
    elk-systemd-services \
    bash \
    connman \
    connman-client \
    sudo \
"