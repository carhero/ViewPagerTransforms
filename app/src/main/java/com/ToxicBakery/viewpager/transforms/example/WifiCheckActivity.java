package com.ToxicBakery.viewpager.transforms.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by adsoft on 15. 10. 1.
 */
public class WifiCheckActivity extends Activity {
    private static final String TAG = "WifiCheckActivity";
    Button connectButton;
    Button proceedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "WifiCheckActivity-onCreate");

        /*if (Build.VERSION.SDK_INT < 16)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else
        {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            ActionBar actionBar = getActionBar();
            actionBar.hide();
        }*/

        setContentView(R.layout.activity_wifi_check);

        connectButton = (Button) findViewById(R.id.connectButton);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(), "WifiCheckActivity-connectButton", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                finish();
            }
        });

        proceedButton = (Button) findViewById(R.id.proceedButton);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "WifiCheckActivity-proceedButton", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(WifiCheckActivity.this, MainActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    // wifi connect button


    // go proceed button

}
