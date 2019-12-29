SUMMARY = "Extended development tools deployed in Elk Audio OS devices"

inherit packagegroup

RDEPENDS_packagegroup-elk-devtools-extended = "\
    gdbserver \
    psplash \
    strace \
    file \
    git \
    dmidecode \
    htop \
    cgdb \
    valgrind \
    tmux \
    perf \
"