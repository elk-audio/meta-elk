SUMMARY = "MDA VST2 plugins for Linux"
LICENSE = "CLOSED"

inherit cmake

SRC_URI = "git://git@bitbucket.org/mindswteam/vst2-cmake.git;protocol=ssh;nobranch=1"
SRCREV = "99c3ba3d5b44602fd74da33f9bf7acb815c45473"

PV = "0.1.0+${SRCREV}"
S = "${WORKDIR}/git"

MDA_PLUGIN_DIR = "/home/mind/plugins/mda-vst2"

OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"
EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release"

do_install() {
    install -d ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaAmbience.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaBandisto.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaBeatBox.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaCombo.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaDe-ess.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaDegrade.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaDelay.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaDetune.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaDither.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaDubDelay.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaDX10.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaDynamics.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaEnvelope.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaEPiano.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaImage.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaJX10.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaLeslie.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaLimiter.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaLooplex.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaLoudness.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaMultiBand.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaOverdrive.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaPiano.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaRezFilter.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaRingMod.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaRoundPan.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaShepard.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaSplitter.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaStereo.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaSubSynth.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaTalkBox.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaTestTone.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaThruZero.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaTracker.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaTransient.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaVocInput.so" ${D}${MDA_PLUGIN_DIR}
    cp "${WORKDIR}/build/plugins/mdaVocoder.so" ${D}${MDA_PLUGIN_DIR}
}

FILES_${PN} += "${MDA_PLUGIN_DIR}"
FILES_${PN} += "${MDA_PLUGIN_DIR}/*"
