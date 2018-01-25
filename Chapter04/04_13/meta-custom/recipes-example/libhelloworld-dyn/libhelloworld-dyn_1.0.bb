DESCRIPTION = "Simple helloworld example dynamic library"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello.c \
           file://world.c \
           file://helloworld.h \
           file://helloworld.pc"

S = "${WORKDIR}"

do_compile() {
       ${CC} ${LDFLAGS} -fPIC -g -c hello.c world.c
       ${CC} ${LDFLAGS} -shared -Wl,-soname,libhelloworld.so.1 -o libhelloworld.so.1.0 hello.o world.o
}

do_install() {
       install -d ${D}${includedir}
       install -d ${D}${libdir}
       install -m 0755 helloworld.h ${D}${includedir}
       install -m 0755 libhelloworld.so.1.0 ${D}${libdir}
       ln -s libhelloworld.so.1.0 ${D}/${libdir}/libhelloworld.so.1
       ln -s libhelloworld.so.1 ${D}/${libdir}/libhelloworld.so
}
