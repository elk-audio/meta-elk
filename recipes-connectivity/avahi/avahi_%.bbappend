
do_install:append() {
    sed -i 's/use-ipv6/\#use-ipv6/' ${D}${sysconfdir}/avahi/avahi-daemon.conf
}
