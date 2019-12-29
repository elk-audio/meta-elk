SUMMARY = "Clang packages deployed in Elk Audio OS devices"

inherit packagegroup

RDEPENDS_packagegroup-elk-clang-pkgs = "\
    clang \
    compiler-rt \
    libcxx \
    llvm-common \
"