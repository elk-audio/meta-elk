require ${BPN}.inc

DEPENDS = "${BPN}-native alsa-lib ncurses glib-2.0"

SRC_URI += " \
    file://0001-Do-not-build-gentables-helper-we-have-to-use-native-.patch \
    file://0002-fluid_synth_nwrite_float-Allow-zero-pointer-for-left.patch \
    file://0003-Use-ARM-NEON-accelaration-for-float-multithreaded-se.patch \
    file://0004-Hack-remove-timer-calls-from-RT-process-callback.patch \
"

# Replace pretty much all the flags since we only want to build the shared library and
# not the command-line synthesizer

EXTRA_OECMAKE = "-Denable-floats=ON -DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')} -Denable-alsa=OFF -Denable-aufile=OFF -Denable-dbus=OFF -Denable-dsound=OFF -Denable-ipv6=OFF -Denable-jack=OFF -Denable-ladspa=OFF -Denable-lash=OFF -Denable-midishare=OFF -Denable-network=OFF -Denable-oss=OFF -Denable-pulseaudio=OFF -Denable-readline=OFF -Denable-systemd=OFF -Denable-threads=OFF -Denable-winmidi=OFF"

do_configure_append() {
    make_tables.exe ${B}/
}
