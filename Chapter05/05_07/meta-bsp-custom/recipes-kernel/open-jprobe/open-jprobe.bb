# Copyright (C) 2014 Packt Publishing.

SUMMARY = "jprobe on do_sys_open kernel module."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"

SRC_URI = " \
    file://jprobe_open.c \
    file://Makefile \
"

S = "${WORKDIR}"
