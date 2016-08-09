/*
Copyright 2014-2016 Intel Corporation

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/


#include <MOE/MOE.h>

#include "ExitHook.h"

#include <stdlib.h>

#include "jni.h"

JNIEXPORT extern "C" void JNICALL Java_org_apache_harmony_jpda_tests_jdwp_Events_NativeMethodDebuggee_caller(JNIEnv* env, jobject obj) {
    jclass cls = env->GetObjectClass(obj);

    jmethodID meth1 = env->GetMethodID(cls, "calledFromCaller1", "()V");
    jmethodID meth2 = env->GetMethodID(cls, "calledFromCaller3", "()V");

    env->CallVoidMethod(obj, meth1);
    env->CallVoidMethod(obj, meth2);

    env->DeleteLocalRef(cls);
}

int main(int argc, char *argv[]) {
    port = atoi(argv[--argc]);
    sendExitStatus(moevm(argc, argv));
}
