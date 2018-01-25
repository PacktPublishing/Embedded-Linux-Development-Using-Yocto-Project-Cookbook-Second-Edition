FROM ubuntu:16.04
MAINTAINER Alex Gonzalez <alex@lindusembedded.com>

# Upgrade system and Yocto Proyect basic dependencies
RUN apt-get update && apt-get -y upgrade && apt-get -y install gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat cpio python python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping libsdl1.2-dev xterm curl

# Set up locales
RUN apt-get -y install locales apt-utils sudo && dpkg-reconfigure locales && locale-gen en_US.UTF-8 && update-locale LC_ALL=en_US.UTF-8 LANG=en_US.UTF-8
ENV LANG en_US.utf8

# Clean up APT when done.
RUN apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# Replace dash with bash
RUN rm /bin/sh && ln -s /bin/bash /bin/sh

# User management
RUN groupadd -g 1000 build && useradd -u 1000 -g 1000 -ms /bin/bash build && usermod -a -G sudo build && usermod -a -G users build

# Install repo
RUN curl -o /usr/local/bin/repo https://storage.googleapis.com/git-repo-downloads/repo && chmod a+x /usr/local/bin/repo

# Run as build user from the installation path
ENV YOCTO_INSTALL_PATH "/opt/yocto"
RUN install -o 1000 -g 1000 -d $YOCTO_INSTALL_PATH
USER build
WORKDIR ${YOCTO_INSTALL_PATH}

# Set the Yocto release
ENV YOCTO_RELEASE "pyro"

# Install Poky 
RUN git clone --branch ${YOCTO_RELEASE} git://git.yoctoproject.org/poky

# Install FSL community BSP
RUN mkdir -p ${YOCTO_INSTALL_PATH}/fsl-community-bsp && cd ${YOCTO_INSTALL_PATH}/fsl-community-bsp && repo init -u https://github.com/Freescale/fsl-community-bsp-platform -b ${YOCTO_RELEASE} && repo sync

# Create a build directory for the FSL community BSP
RUN mkdir -p ${YOCTO_INSTALL_PATH}/fsl-community-bsp/build

# Make /home/build the working directory
WORKDIR /home/build
