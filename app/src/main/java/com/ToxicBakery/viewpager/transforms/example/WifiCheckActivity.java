package com.ToxicBakery.viewpager.transforms.example;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by adsoft on 15. 10. 1.
 */
public class WifiCheckActivity extends Activity {
    private static final String TAG = "WifiCheckActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_check);

        Log.d(TAG, "WifiCheckActivity-onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    // wifi connect button


    // go proceed button

}
