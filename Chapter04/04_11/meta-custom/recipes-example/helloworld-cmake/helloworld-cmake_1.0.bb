DESCRIPTION = "Simple helloworld cmake application"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://CMakeLists.txt \
           file://helloworld.c"
S = "${WORKDIR}"

inherit cmake

EXTRA_OECMAKE = ""
