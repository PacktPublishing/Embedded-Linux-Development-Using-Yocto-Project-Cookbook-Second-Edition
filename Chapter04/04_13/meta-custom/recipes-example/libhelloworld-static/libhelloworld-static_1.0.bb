DESCRIPTION = "Simple helloworld example static library"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello.c \
           file://world.c \
           file://helloworld.h \
           file://helloworld.pc"

S = "${WORKDIR}"

do_compile() {
        ${CC} -c hello.c world.c
        ${AR} -cvq libhelloworld.a hello.o world.o
}

do_install() {
        install -d ${D}${includedir}
        install -d ${D}${libdir}
        install -m 0755 helloworld.h ${D}${includedir}
        install -m 0755 libhelloworld.a ${D}${libdir}
}
