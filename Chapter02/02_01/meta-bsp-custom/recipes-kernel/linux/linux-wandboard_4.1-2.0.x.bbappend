FILESEXTRAPATHS_prepend := "${THISDIR}/${BP}:"

SRC_URI_append = " file://0001-01_02-Add-a-custom-device-tree-and-configuration.patch"
COMPATIBLE_MACHINE = "(wandboard|wandboard-custom)"
