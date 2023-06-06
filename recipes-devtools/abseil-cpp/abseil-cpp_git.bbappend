# Abseil C++ append
# Install the right abseil-cpp needed for GRPC 1.48.0

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

BRANCH = "lts_2022_06_23"
SRCREV = "273292d1cfc0a94a65082ee350509af1d113344d"
PV = "20220623.rc1"

# Remove patch meant for 20211102.0 and add one ported for 20220623.rc1
SRC_URI:remove = "file://0001-absl-always-use-asm-sgidefs.h.patch"
SRC_URI:append = "file://0001-Fixes-mips-musl-build-since-sgidefs.h-is-not-present.patch"
