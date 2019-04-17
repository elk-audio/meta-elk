SUMMARY = "Package group for dev tools needed by elk during development"

inherit packagegroup

RDEPENDS_packagegroup-elk-devtools = "util-linux \
    gdbserver \
    psplash \
    strace \
    packagegroup-core-buildessential \
    sudo \
    file \
    git \
    vim \
    cmake \
    dmidecode \
    htop \
    connman \
    connman-client \
    cmake \
    nano \
    cgdb \
    valgrind \
    tmux \
    libstdc++ \
    libstdc++-staticdev"