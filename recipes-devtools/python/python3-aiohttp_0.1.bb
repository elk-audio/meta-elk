SUMMARY = "Recipe for aiohttp python library"
HOMEPAGE = "https://github.com/aio-libs/aiohttp"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3bf3d48554bdca1ea7fdb48de378c2ca"

SRC_URI = "gitsm://github.com/aio-libs/aiohttp;protocol=https;nobranch=1"
SRCREV = "0a26acc1de9e1b0244456b7881ec16ba8bb64fc3"

S = "${WORKDIR}/git/"

inherit setuptools3

