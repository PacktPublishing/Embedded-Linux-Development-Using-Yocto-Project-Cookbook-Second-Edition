DESCRIPTION = "Minimal console-only initramfs image."

PACKAGE_INSTALL= "\
        base-files \
        base-passwd \
        busybox \
        sysvinit \
        initscripts \
        ${ROOTFS_BOOTSTRAP_INSTALL} \
"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

IMAGE_FEATURES = ""

export IMAGE_BASENAME = "image-small-initramfs"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES} ${INITRAMFS_FSTYPES}.u-boot"
inherit image

IMAGE_ROOTFS_SIZE = "8192"
