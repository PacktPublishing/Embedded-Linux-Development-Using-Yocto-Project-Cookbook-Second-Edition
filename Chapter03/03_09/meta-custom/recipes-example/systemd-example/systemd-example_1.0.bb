DESCRIPTION = "Example systemd service"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    file://systemd-example.service \
    file://simple-service.c \
"

inherit systemd

S = "${WORKDIR}"

SYSTEMD_SERVICE_${PN} = "systemd-example.service"

do_compile () {
    ${CC} ${LDFLAGS} simple-service.c -o simple-service
}

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/simple-service ${D}${bindir}
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/systemd-example.service ${D}${systemd_unitdir}/system
    sed -i -e 's,@BINDIR@,${bindir},g' ${D}${systemd_unitdir}/system/systemd-example.service
}
