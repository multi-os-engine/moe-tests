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


#include "ExitHook.h"

#include <CoreFoundation/CoreFoundation.h>

#include <CoreFoundation/CoreFoundation.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/tcp.h>

#include <stdlib.h>

int port = 0;

void sendExitStatus(int status) {
    struct sockaddr_in sin;

    memset(&sin, 0, sizeof(sin));
    sin.sin_len = sizeof(sin);
    sin.sin_family = AF_INET;
    sin.sin_port = htons(port);
    sin.sin_addr.s_addr= INADDR_ANY;

    int serverSocket = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP);
    static const int kOne = 1;
    setsockopt(serverSocket, IPPROTO_TCP, TCP_NODELAY, &kOne, sizeof(kOne));

    if (connect(serverSocket, (struct sockaddr*)&sin, sizeof(struct sockaddr_in)) >= 0) {
        int val = htonl(status);
        send(serverSocket, &val, sizeof(int), 0 );
    }

    close(serverSocket);
}

extern void __exit(int) __attribute__((noreturn));

void exit(int status) {
    sendExitStatus(status);
    __exit(status);
}
