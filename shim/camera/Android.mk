# Copyright (C) 2020 LineageOS Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

LOCAL_PATH := $(call my-dir)

### CAMERA PROVIDER
include $(CLEAR_VARS)

LOCAL_SRC_FILES := vendor_samsung_hardware_camera_provider.cpp
LOCAL_SHARED_LIBRARIES := vendor.samsung.hardware.camera.provider@3.0-impl
LOCAL_MODULE := libshim_vendor_samsung_camera_provider
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE_CLASS := SHARED_LIBRARIES
LOCAL_VENDOR_MODULE := true
LOCAL_MULTILIB := 32

include $(BUILD_SHARED_LIBRARY)

### SYMLINK
include $(CLEAR_VARS)

CAMERA_PROVIDER_LIBRARY := /vendor/lib/hw/vendor.samsung.hardware.camera.provider@3.0-impl.so

CAMERA_PROVIDER_SYMLINK := $(TARGET_OUT_VENDOR)/lib/vendor.samsung.hardware.camera.provider@3.0-impl.so
$(CAMERA_PROVIDER_SYMLINK): $(LOCAL_INSTALLED_MODULE)
	@echo "Creating lib/vendor.samsung.hardware.camera.provider@3.0-impl.so symlink: $@"
	@mkdir -p $(dir $@)
	$(hide) ln -sf $(CAMERA_PROVIDER_LIBRARY) $@

ALL_DEFAULT_INSTALLED_MODULES += \
	$(CAMERA_PROVIDER_SYMLINK)
