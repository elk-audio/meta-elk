SUMMARY = "Package group for Clang packages"

inherit packagegroup

RDEPENDS_packagegroup-elk-clang-dev-pkgs = "libcxx-staticdev \
    compiler-rt-staticdev \
    "