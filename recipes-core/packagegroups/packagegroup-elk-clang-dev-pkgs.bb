SUMMARY = "Clang packages deployed in Elk Audio OS devices"

inherit packagegroup

RDEPENDS_packagegroup-elk-clang-dev-pkgs = "\
    libcxx-staticdev \
    compiler-rt-staticdev \
"