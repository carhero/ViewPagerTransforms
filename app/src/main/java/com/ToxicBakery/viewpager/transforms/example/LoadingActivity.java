package com.ToxicBakery.viewpager.transforms.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/*import java.util.logging.Handler;
import java.util.logging.LogRecord;*/

public class LoadingActivity extends Activity {

    private static final String TAG = "LoadingActivity";
    Button buttonConnect;
    Button buttonProceed;
    TextView textViewHelpMsg;
    ImageView imageViewWifiIcon;
    private SendMassgeHandler mMainHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getActionBar().hide();

        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.
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

        // 메인 핸들러 생성
        mMainHandler = new SendMassgeHandler();

        ThreadSendMessage threadSendMessage = new ThreadSendMessage();
        threadSendMessage.run();
        threadSendMessage.setIsRunable(true);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_loading);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//		if (m_upnpProcessor != null) {
//			m_upnpProcessor.unbindUpnpService();
//		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loading, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Handler 클래스
    class SendMassgeHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what)
            {
                case 0x00:
                    // Icon & Text create
                    buttonConnect = (Button)findViewById(R.id.connectButton);
                    buttonProceed = (Button)findViewById(R.id.proceedButton);
                    imageViewWifiIcon = (ImageView)findViewById(R.id.wifi_cant_use);
                    textViewHelpMsg = (TextView)findViewById(R.id.helpText);

                    Log.d(TAG, "handlerMessage : " + msg.what);
                    break;

                case 0x01:
                    Log.d(TAG, "handlerMessage : " + msg.what);
                    break;

                case 0x02:
                    Log.d(TAG, "handlerMessage : " + msg.what);
                    break;

                case 0x03:
                    Log.d(TAG, "handlerMessage : " + msg.what);
                    if(isWifiConnected())   // Wifi 가 활성화 되어 있으면 Main Page로 진입한다.
                    {
                        startActivity(new Intent(LoadingActivity.this, MainActivity.class));
                    }
                    else
                    {
                        startActivity(new Intent(LoadingActivity.this, WifiCheckActivity.class));
                    }
                    finish();
                    break;

                default:
                    Log.d(TAG, "handlerMessage : " + msg.what);
                    break;
            }
        }
    };



    // Thread
    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "LoadingActivity-OnResume");

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    handler.sendEmptyMessage(0x00);

                    Thread.sleep(1000);
                    handler.sendEmptyMessage(0x01);
                    Thread.sleep(700);
                    handler.sendEmptyMessage(0x02);
                    Thread.sleep(400);
                    handler.sendEmptyMessage(0x03);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();*/
    }

    // User API
    public  boolean isWifiConnected(){
        ConnectivityManager connManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return mWifi.isConnected();
    }

    // Thread task
    public class ThreadSendMessage extends Thread {
        private boolean isRunable = true;

        public void setIsRunable(boolean isRunable) {
            this.isRunable = isRunable;
        }
        @Override
        public void run() {
            super.run();

            while(isRunable){
                Message msg = mMainHandler.obtainMessage();
                try {
                    Thread.sleep(100);
                    msg.what = 0;
                    mMainHandler.sendEmptyMessage(msg.what);
                    Thread.sleep(100);
                    msg.what = 1;
                    mMainHandler.sendEmptyMessage(msg.what);
                    Thread.sleep(100);
                    msg.what = 2;
                    mMainHandler.sendEmptyMessage(msg.what);
                    Thread.sleep(100);
                    msg.what = 3;
                    mMainHandler.sendEmptyMessage(msg.what);
                    break;
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            isRunable = false;
        }
    }
}
