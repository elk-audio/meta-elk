HOMEPAGE = "https://github.com/elk-audio/sushi-webui"
LICENSE = "AGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=216109e2c1c3eaf57de2bfc18c11c9f8"

SRC_URI = "git://github.com/elk-audio/sushi-webui;protocol=https;nobranch=1"
SRCREV = "cbd914639b9d7e1f54f195c454707a5c57ca930c"

# Keep this ahead of the previous release: opkg compares versions as strings and
# the git hash alone can sort lower, which makes an upgrade look like a downgrade.
PV = "0.2.0+git"
