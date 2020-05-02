/*
 * Copyright (C) 2020 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.samsungaudioservice;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class SamsungAudioService extends Service {

    public static final String TAG = "SamsungAudioService";

    @Override
    public void onCreate() {
        Log.d(SamsungAudioService.TAG, "Service started");
        IntentFilter filter = new IntentFilter("com.samsung.intent.action.WB_AMR");
        registerReceiver(new SamsungAudioReceiver(), filter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
