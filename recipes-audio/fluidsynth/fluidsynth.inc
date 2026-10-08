SUMMARY = "Fluidsynth is a software synthesizer"
HOMEPAGE = "http://www.fluidsynth.org/"
SECTION = "libs/multimedia"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fc178bcd425090939a8b634d1d6a9594"

PV = "2.0.7"
SRC_URI = "git://github.com/FluidSynth/fluidsynth.git;branch=master;protocol=https"
SRCREV = "62b38b1c66aec606f83b322bb03bd84810bbda41"
inherit cmake pkgconfig lib_package

# fluidsynth 2.0.7 declares cmake_minimum_required < 3.5, rejected by CMake 4
EXTRA_OECMAKE:append = " -DCMAKE_POLICY_VERSION_MINIMUM=3.5"
