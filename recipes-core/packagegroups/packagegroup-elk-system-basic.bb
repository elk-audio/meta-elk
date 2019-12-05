SUMMARY = "Package group for system packages needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-system-basic = "kernel-modules \
    custom-owner \
    elk-systemd-services \
    bash \
    "
