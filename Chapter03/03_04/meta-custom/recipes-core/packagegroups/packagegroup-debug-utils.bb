SUMMARY = "Debug applications packagegroup"

inherit packagegroup

RDEPENDS_${PN} = "\
    trace-cmd \
    perf \
"
