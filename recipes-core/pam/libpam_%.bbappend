SUMMARY = "Allows mind user to have unlimited mem to be locked and have prio levels upto 99"

do_install:append() {
    echo "session required pam_limits.so" >> ${D}${sysconfdir}/pam.d/common-session
    echo "session required pam_limits.so" >> ${D}${sysconfdir}/pam.d/common-session-noninteractive
    echo "mind	-	memlock	unlimited" >> ${D}${sysconfdir}/security/limits.conf
    echo "mind	-	rtprio	99" >> ${D}${sysconfdir}/security/limits.conf
}
