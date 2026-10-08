SUMMARY = "Software stack to serve web based GUIs from the device"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

# Only installed when ELK_WEB_GUI = "1" (default "0", see conf/layer.conf).
# Layers and kas configs opt in with:
#   ELK_WEB_GUI = "1"
# and images pull this packagegroup in conditionally, e.g.:
#   IMAGE_INSTALL += "${@oe.utils.conditional('ELK_WEB_GUI', '1', 'packagegroup-elk-web-gui', '', d)}"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = "\
    ${PN} \
    ${PN}-nodejs \
    ${PN}-python \
    ${PN}-nginx \
"

RDEPENDS:${PN} = "\
    ${PN}-nodejs \
    ${PN}-python \
    ${PN}-nginx \
"

# Node.js runtime and npm, e.g. for scraporchestra
RDEPENDS:${PN}-nodejs = "\
    nodejs \
    nodejs-npm \
"

# Python web frameworks, ASGI server and websocket support.
# No fastapi: it requires pydantic-core, which pulls in the Rust toolchain.
RDEPENDS:${PN}-python = "\
    python3-aiohttp \
    python3-uvicorn \
    python3-flask \
    python3-websockets \
    python3-socketio \
"

# Static files and reverse proxy
RDEPENDS:${PN}-nginx = "\
    nginx \
"
