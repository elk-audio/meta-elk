# Adapted from recipe in meta-multimedia layer:
# http://cgit.openembedded.org/meta-openembedded/tree/meta-multimedia?h=master
# with extra patch to remove timer-related calls that cause lock-ups on Xenomai.
# Original license: MIT

require ${BPN}.inc

DEPENDS = "\
    ${BPN}-native\
    alsa-lib \
    ncurses \
    glib-2.0\
"

SRC_URI += "\
    file://0001-Do-not-build-gentables-helper-we-have-to-use-native-.patch \
    file://0002-fluid_synth_nwrite_float-Allow-zero-pointer-for-left.patch \
    file://0003-Use-ARM-NEON-accelaration-for-float-multithreaded-se.patch \
    file://0004-Hack-remove-timer-calls-from-RT-process-callback.patch \
"

# Replace pretty much all the flags since we only want to build the shared library and
# not the command-line synthesizer

EXTRA_OECMAKE = "\
    -Denable-floats=ON \
    -DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')} \
    -Denable-alsa=OFF \
    -Denable-aufile=OFF \
    -Denable-dbus=OFF \
    -Denable-dsound=OFF \
    -Denable-ipv6=OFF \
    -Denable-jack=OFF \
    -Denable-ladspa=OFF \
    -Denable-lash=OFF \
    -Denable-midishare=OFF \
    -Denable-network=OFF \
    -Denable-oss=OFF \
    -Denable-pulseaudio=OFF \
    -Denable-readline=OFF \
    -Denable-systemd=OFF \
    -Denable-threads=OFF \
    -Denable-winmidi=OFF \
"

OECMAKE_C_FLAGS_RELEASE += " -O3 -ffast-math"
OECMAKE_CXX_FLAGS_RELEASE += " -O3 -ffast-math"

do_configure:append() {
    make_tables.exe ${B}/
}
