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

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioSystem;
import android.util.Log;

public class SamsungAudioReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        int extra_rat = intent.getIntExtra("EXTRA_RAT", 0);
        int extra_state = intent.getIntExtra("EXTRA_STATE", 0);

        switch(extra_state) {
            case 8:
                Log.d(SamsungAudioService.TAG, "wb_amr swb");
                AudioSystem.setParameters("g_call_band=swb");
                break;
            case 1:
                Log.d(SamsungAudioService.TAG, "wb_amr wb");
                AudioSystem.setParameters("g_call_band=wb");
                break;
            default:
                Log.d(SamsungAudioService.TAG, "wb_amr nb");
                AudioSystem.setParameters("g_call_band=nb");
                break;
        }

        if (extra_rat != 0) {
            AudioSystem.setParameters("g_call_rat_type=" + extra_rat);
        }
    }
}
