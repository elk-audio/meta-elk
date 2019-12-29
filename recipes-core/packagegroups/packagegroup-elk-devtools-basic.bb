SUMMARY = "Basic development tools deployed in Elk Audio OS devices"

inherit packagegroup

RDEPENDS_packagegroup-elk-devtools-basic = "\
    util-linux \
    packagegroup-core-buildessential \
    vim \
    cmake \
    nano \
"