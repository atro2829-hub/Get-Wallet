package com.getwallet.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Receives FCM token broadcasts from GetWalletFirebaseMessagingService
 * and saves them to SharedPreferences for the web layer to access.
 */
public class FCMTokenReceiver extends BroadcastReceiver {

    private static final String TAG = "GetWalletFCMTokenReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.getwallet.app.FCM_TOKEN".equals(action)) {
            String token = intent.getStringExtra("token");
            if (token != null) {
                Log.d(TAG, "FCM token received, saving to SharedPreferences");
                // Save to SharedPreferences for the web layer to pick up
                context.getSharedPreferences("get_wallet_prefs", Context.MODE_PRIVATE)
                        .edit()
                        .putString("fcm_token", token)
                        .apply();
            }
        }
    }
}