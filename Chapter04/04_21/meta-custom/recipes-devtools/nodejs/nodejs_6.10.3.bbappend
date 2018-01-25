FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}-${PV}:"
SRC_URI_append = " file://v8_fix_build_errors_with_g++_7.patch"
