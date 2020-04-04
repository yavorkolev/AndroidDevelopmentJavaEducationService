package com.example.serviceproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MyAndroidServiceTutorial extends Service {

    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
         player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);


        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            public void run() {
                player.setLooping(true);
                player.start();
            }
        }, player.getDuration());

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
