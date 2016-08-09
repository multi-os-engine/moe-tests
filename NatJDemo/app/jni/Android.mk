DEPENDENCY_PATH := $(call my-dir)
LOCAL_PATH := $(abspath $(DEPENDENCY_PATH))
include $(CLEAR_VARS)

LOCAL_MODULE := jni

LOCAL_CFLAGS := -DNDEBUG -std=c99

LOCAL_CPP_FEATURES := \
	exceptions

LOCAL_SRC_FILES := $(wildcard $(LOCAL_PATH)/../src/androidTest/native/*.c)

include $(BUILD_SHARED_LIBRARY)
