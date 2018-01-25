SUMMARY = "An example node.js hello world server"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2459e4101d5fabab9d291bde6cdc5a56"

SRC_URI = "npm://registry.npmjs.org;name=nodejs-helloworld;version=${PV}"

NPM_SHRINKWRAP := "${THISDIR}/${PN}/npm-shrinkwrap.json"
NPM_LOCKDOWN := "${THISDIR}/${PN}/lockdown.json"

inherit npm

# Must be set after inherit npm since that itself sets S
S = "${WORKDIR}/npmpkg"
LICENSE_${PN} = "MIT"

RDEPENDS_${PN} = "nodejs"

