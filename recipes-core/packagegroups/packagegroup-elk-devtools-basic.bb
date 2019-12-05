SUMMARY = "Package group for dev tools needed by elk during development"

inherit packagegroup

RDEPENDS_packagegroup-elk-devtools-basic = "util-linux \
    packagegroup-core-buildessential \
    sudo \
    vim \
    connman \
    connman-client \
    cmake \
    nano \
    "
