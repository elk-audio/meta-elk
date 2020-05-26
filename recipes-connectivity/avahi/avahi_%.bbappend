
do_install_append() {
    sed -i 's/use-ipv6/\#use-ipv6/' ${D}${sysconfdir}/avahi/avahi-daemon.conf
}
