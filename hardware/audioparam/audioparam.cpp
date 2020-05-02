/*
 * Copyright (C) 2018 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

#include <string.h>
#include <iostream>
#include <media/AudioSystem.h>

using std::cout;
using std::endl;

int main(int argc, char *argv[])
{
    const char *cmd = NULL;

    if (argc != 3) {
        cout << "Usage: [get|set] PARAM" << endl;
        return 0;
    }

#if 0
    cout << "argc: " << argc << endl;
    for (int i = 0; i < argc; i++) {
        cout << "argv[" << i << "]: " << argv[i] << endl;
    }
#endif

    cmd = argv[1];
    if (strcmp(cmd, "get") == 0) {
        android::String8 keys = android::String8(argv[2]);
        android::String8 keypairs = android::AudioSystem::getParameters(keys);

        if (keypairs.isEmpty()) {
            cout << "KEY EMPTY" << endl;
        } else {
            cout << "VALUE: " << keypairs << endl;
        }
    } else if (strcmp(cmd, "set") == 0) {
        android::String8 keypair = android::String8(argv[2]);
        android::status_t status;

        cout << "SET: " << keypair << endl;

        status = android::AudioSystem::setParameters(keypair);
        if (status == android::OK) {
            cout << "  OK" << endl;
        } else {
                cout << "  FAILED" << endl;
            return 1;
        }
    }

    return 0;
}
