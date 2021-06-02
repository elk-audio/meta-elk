# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE.txt
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/oneapi-src/oneTBB.git;protocol=https;branch=onetbb_2021"

# Modify these as desired
PV = "0.1+git${SRCPV}"
SRCREV = "2dba2072869a189b9fdab3ffa431d3ea49059a19"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: TBB
# NOTE: the following library dependencies are unknown, ignoring: mkl_sequential mkl_core mkl_intel_lp64
#       (this is based on recipes that have previously been built and packaged)
inherit cmake python3native

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = " -DCMAKE_BUILD_TYPE=Release"

