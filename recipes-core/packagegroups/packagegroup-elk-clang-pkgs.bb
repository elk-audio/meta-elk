SUMMARY = "Package group for Clang packages"

inherit packagegroup

RDEPENDS_packagegroup-elk-clang-pkgs = " clang \
    compiler-rt \
    libcxx \
    llvm-common \
    "