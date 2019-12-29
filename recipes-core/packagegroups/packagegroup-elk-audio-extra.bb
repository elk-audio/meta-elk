SUMMARY = "Extra audio libraries needed for some specific use cases"

inherit packagegroup

RDEPENDS_packagegroup-elk-audio-extra = "\
    libjack \
    jack-server \
    jack-utils \
    stk \
    csound \
    fluidsynth \
    lv2 \
    sord \
    serd \
    sratom \
    lilv \
"