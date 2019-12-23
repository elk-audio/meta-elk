# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI = "git://sigrok.org/libserialport;branch=libserialport-0.1.1"

inherit autotools

DEPENDS += "autoconf-native"

# Modify these as desired

PV = "0.1.1+git${SRCPV}"
SRCREV = "348a6d353af8ac142f68fbf9fe0f4d070448d945"

S = "${WORKDIR}/git"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line


# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

do_prepare_autoconf () {

libserial_src="${WORKDIR}/git"

${libserial_src}/autogen.sh

}

addtask prepare_autoconf after do_prepare_recipe_sysroot before do_configure
