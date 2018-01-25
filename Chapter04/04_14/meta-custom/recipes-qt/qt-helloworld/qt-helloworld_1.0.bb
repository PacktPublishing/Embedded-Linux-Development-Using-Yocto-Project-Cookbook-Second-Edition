DESCRIPTION = "Simple QT helloworld example"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://qt_hello_world.cpp \
           file://qt_hello_world.pro"

DEPENDS += "qtbase fontconfig"

S = "${WORKDIR}"

inherit qmake5

do_install() {
         install -d ${D}${bindir}
         install -m 0755 qt_hello_world ${D}${bindir}
}
