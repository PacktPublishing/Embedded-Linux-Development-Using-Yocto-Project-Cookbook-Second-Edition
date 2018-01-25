FILESEXTRAPATHS_prepend := "${THISDIR}/${BP}:"

WANDBOARD_GITHUB_MIRROR = "git://github.com/yoctocookbook2ndedition/linux.git"
SRCBRANCH = "4.1-2.0.x-imx-dev"
SRCREV = "${AUTOREV}"
SRC_URI = "${WANDBOARD_GITHUB_MIRROR};protocol=https;branch=${SRCBRANCH} \
           file://defconfig \
"

KERNEL_MODULE_AUTOLOAD += "g_ether"
KERNEL_MODULE_PROBECONF += "g_ether"
module_conf_g_ether = "options g_ether iProduct=Wandboard iManufacturer=Technexion"

COMPATIBLE_MACHINE = "(wandboard|wandboard-custom)"
