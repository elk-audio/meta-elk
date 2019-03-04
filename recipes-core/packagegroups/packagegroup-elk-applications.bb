SUMMARY = "Package group for user space applications and services needed by elk"

inherit packagegroup

RDEPENDS_packagegroup-elk-applications = "\
    sushi \
    sensei \
    "
