do_install_append () {
    cat >> ${D}${sysconfdir}/fstab <<EOF

# Mount smackfs
smackfs /sys/fs/smackfs smackfs defaults 0 0

EOF
}

