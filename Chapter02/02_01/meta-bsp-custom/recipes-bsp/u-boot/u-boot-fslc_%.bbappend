FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI_append = " file://0001-02_01-Add-a-custom-wandboard-custom-machine.patch"

COMPATIBLE_MACHINE = "(wandboard|wandboard-custom)"
