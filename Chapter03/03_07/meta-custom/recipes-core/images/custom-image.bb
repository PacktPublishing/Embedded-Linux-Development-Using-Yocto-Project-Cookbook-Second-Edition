require recipes-core/images/core-image-minimal.bb
IMAGE_FEATURES += "ssh-server-dropbear package-management"

inherit extrausers

EXTRA_USERS_PARAMS = "\
usermod -p 9PfNy0O1z0O5g root; \
"
