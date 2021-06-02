# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://license;md5=0c2e6a4fa44638a3508ae1415efa49d3"

SRC_URI = "git://git@bitbucket.org/mindswteam/anyrpc.git;protocol=ssh"

# Modify these as desired
PV = "0.1+git${SRCPV}"
SRCREV = "18ed1212c5553e39002b9e54a5f50cdd440247af"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: Msgpack Log4cplus
DEPENDS = "googletest"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "\
    -DCMAKE_CXX_STANDARD=17 \
    -DBUILD_WITH_LOG4CPLUS=FALSE \
    -DBUILD_PROTOCOL_MESSAGEPACK=FALSE \
    -DBUILD_PROTOCOL_XML=FALSE \
    -DBUILD_EXAMPLES=FALSE \
"

