package com.devaartem.roomreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import java.util.logging.Handler;

public class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    int i;

    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context, R.raw.ring);
        mp.start();
        for (i=1;i<=5;i++)
        {
            if(i%2==0)Toast.makeText(context, "Alarm ringing....", Toast.LENGTH_LONG).show();
            else Toast.makeText(context, "Check your task....", Toast.LENGTH_LONG).show();
        }
    }

}