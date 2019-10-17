SUMMARY = "A sound and music computing system"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

inherit cmake gettext python-dir

# TBD: fltk is not propely detected
DEPENDS += " \
    flex-native \
    bison-native \
    swig-native \
    python \
    libsndfile1 \
    fluidsynth \
    curl \
    liblo \
    stk \
    libvorbis \
    libeigen \
    libwebsockets \
"

SRC_URI = " \
    git://github.com/csound/csound.git;nobranch=1 \
    file://0001-Do-not-set-include-path-to-usr-local-include.patch \
    file://0002-Do-not-use-try_run-for-portaudio.patch \
"
SRCREV = "3b08a449cc147dec35ba843ced86e0058a9ac865"
S = "${WORKDIR}/git"
PV = "6.13.0"

# Where to get lua-version from?
LUA_VERSION = "5.3"

EXTRA_OECMAKE += " \
    -DUSE_DOUBLE=OFF \
    -DBUILD_BELA=OFF \
    -DBUILD_CUDA_OPCODES=OFF \
    -DBUILD_FRAMEBUFFER_OPCODES=OFF \
    -DBUILD_IMAGE_OPCODES=OFF \
    -DBUILD_JACK_OPCODES=OFF \
    -DUSE_ALSA=OFF \
    -DUSE_AUDIOUNIT=OFF \
    -DUSE_COREMIDI=OFF \
    -DUSE_FLTK=OFF \
    -DUSE_JACK=OFF \
    -DUSE_PORTAUDIO=OFF \
    -DUSE_PORTMIDI=OFF \
    -DUSE_PULSEAUDIO=OFF \
    -DBUILD_PYTHON_INTERFACE=OFF \
    -DPYTHON_MODULE_INSTALL_DIR=${PYTHON_SITEPACKAGES_DIR} \
    -DUSE_LIB64=${@bb.utils.contains("baselib", "lib64", "ON", "OFF",d)} \
"

OECMAKE_C_FLAGS_RELEASE += " -O3 -ffast-math"
OECMAKE_CXX_FLAGS_RELEASE += " -O3 -ffast-math"

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'pulseaudio', d)}"
PACKAGECONFIG[pulseaudio] = "-DUSE_PULSEAUDIO=ON,-DUSE_PULSEAUDIO=OFF,pulseaudio,pulseaudio-server"
PACKAGECONFIG[luajit] = "-DLUA_MODULE_INSTALL_DIR=${libdir}/lua/${LUA_VERSION},,luajit"

PACKAGES =+ " \
    ${PN}-python2 \
    ${PN}-luajit \
"

FILES_${PN}-python2 = "${PYTHON_SITEPACKAGES_DIR}"
RDEPENDS_${PN}-python2 += "python"

FILES_${PN}-luajit = "${libdir}/lua"
