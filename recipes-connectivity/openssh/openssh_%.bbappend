# OpenSSH append
# Add custom ssh configuration

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://sshd_config"
