SUMMARY = "Package group for system packages needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-system-pkgs = "kernel-modules \
    custom-owner \
    elk-systemd-services"