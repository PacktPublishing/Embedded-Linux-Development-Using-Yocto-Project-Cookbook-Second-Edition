FILESEXTRAPATHS_prepend := "${THISDIR}/${BP}:"

WANDBOARD_GITHUB_MIRROR = "git://github.com/yoctocookbook2ndedition/linux.git"
SRCBRANCH = "4.1-2.0.x-imx-dev"
SRCREV = "${AUTOREV}"
SRC_URI = "${WANDBOARD_GITHUB_MIRROR};protocol=https;branch=${SRCBRANCH} \
           file://defconfig \
"

COMPATIBLE_MACHINE = "(wandboard|wandboard-custom)"
