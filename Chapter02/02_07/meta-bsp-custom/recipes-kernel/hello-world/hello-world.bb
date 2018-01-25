# Copyright (C) 2017 Packt Publishing.

SUMMARY = "Simplest hello world kernel module."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

SRC_URI = " \
    file://hello_world.c \
    file://Makefile \
"

S = "${WORKDIR}"

COMPATIBLE_MACHINE = "(wandboard)"
