SUMMARY = "QT5 examples packagegroup"

inherit packagegroup

RDEPENDS_${PN} = " \
    liberation-fonts \
    icu \
    qtbase-examples \
    qt3d-examples \
    qtconnectivity-examples \
    qtdeclarative-examples \
    qtdeclarative-tools \
    qtmultimedia-examples \
    qtsvg-examples \
    cinematicexperience \
    qt5-demo-extrafiles \
    qt5everywheredemo \
    qtsmarthome \
"
