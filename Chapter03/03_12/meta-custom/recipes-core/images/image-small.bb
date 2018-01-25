DESCRIPTION = "Minimal console-only image."

IMAGE_INSTALL= "\
        base-files \
        base-passwd \
        busybox \
        sysvinit \
        initscripts \
"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit image

IMAGE_ROOTFS_SIZE = "8192"
