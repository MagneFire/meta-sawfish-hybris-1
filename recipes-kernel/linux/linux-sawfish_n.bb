require recipes-kernel/linux/linux.inc
inherit gettext

SECTION = "kernel"
SUMMARY = "Android kernel for the Huawei Watch 2 Bluetooth"
HOMEPAGE = "https://android.googlesource.com/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
COMPATIBLE_MACHINE = "sawfish"

#    file://0001-Importante.patch 
#    file://0001-Revert-msm-mdss-fix-video-mode-clk-refcount-issue-wh.patch 
#SRC_URI = " git://android.googlesource.com/kernel/msm;branch=android-msm-sawshark-3.18-nougat-mr1-wear;protocol=https
#SRC_URI = " git://android.googlesource.com/kernel/msm;branch=android-msm-sawshark-3.18-oreo-wear-dr;protocol=https 
#SRC_URI = "git://github.com/toffyjan/Huwaei_watch_2_sawshark.git;protocol=https
SRC_URI = "git://github.com/travismills82/android_kernel_huawei_sawshark.git;branch=oreo-wear-dr;protocol=https \
    file://defconfig \
    file://img_info \
    file://0001-scripts-dtc-Remove-redundant-YYLOC-global-declaratio.patch \
    file://0006-ARM-uaccess-remove-put_user-code-duplication.patch \
    file://0001-Backport-mainline-4.1-Bluetooth-subsystem.patch \
    file://0005-Revert-BT-Delete-the-file-board-8909-rfkill.c.patch \
    file://0006-bluetooth-Import-Bluesleep-driver.patch \
    file://0007-bluesleep-Use-kernel-s-HCI-events-instead-of-proc-bl.patch \
    file://0008-Bluetooth-Fix-incorrect-gpio-definition-in-device-tr.patch \
    file://0001-touch-Increase-debuging-mask-for-tap-to-wake-debug.patch \
    file://0001-cyttp5-Add-delay-for-wakeup-report.patch \
"
# toffyjan
# SRCREV = "4687fe2ddbd4031e076677301d9dce560bed3bf6"
# travis
SRCREV = "430a339a55864834c89c739cfe70cbecfbc6eecb"
# Oreo
# SRCREV = "51d550c70b9e35dbeeaf93a505e94ecbef818291"
# Nougat?
#SRCREV = "66cf3d5be07a599af417695e4f22f304af667979"
LINUX_VERSION ?= "3.18"
PV = "${LINUX_VERSION}+oreo"
S = "${WORKDIR}/git"
B = "${S}"

do_install_append() {
    rm -rf ${D}/usr/src/usr/
}

BOOT_PARTITION = "/dev/mmcblk0p29"

inherit mkboot old-kernel-gcc-hdrs
