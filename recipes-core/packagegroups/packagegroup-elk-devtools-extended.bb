SUMMARY = "Package group for dev tools needed by elk during development"

inherit packagegroup

RDEPENDS_packagegroup-elk-devtools-extended = "gdbserver \
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
