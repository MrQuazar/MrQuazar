package com.devaartem.roomreminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TextReminder extends AppCompatActivity {
    Button goBack,timer,setTimer,writeText;
    TextView countTime;
    int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_reminder);
        goBack = (Button) findViewById(R.id.goBack);
        timer=(Button)findViewById(R.id.timer);
        setTimer=(Button)findViewById(R.id.setTimer);
        writeText=(Button)findViewById(R.id.writeText);
        countTime=(TextView) findViewById(R.id.countTime);
        TimePicker picker2=(TimePicker)findViewById(R.id.timePicker2);
        picker2.setIs24HourView(true);
        picker2.setEnabled(false);
        timer.setEnabled(false);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k= new Intent(TextReminder.this,Selection.class);
                startActivity(k);
            }
        });

        writeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j= new Intent(TextReminder.this, Texty.class);
                startActivity(j);
            }
        });
        setTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.setEnabled(true);
                picker2.setEnabled(true);
            }
        });


        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour=0,minute=0,cd=0;
                setTimer.setEnabled(false);
                picker2.setEnabled(false);
                if (Build.VERSION.SDK_INT >= 23 ){
                    hour = picker2.getHour();
                    minute = picker2.getMinute();
                }
                cd=(minute*60)+(hour*3600);
                new CountDownTimer((cd*1000),1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        counter++;
                        if(counter%2==0)
                        {
                            countTime.setText("RoomReminder");
                        }
                        else {
                            countTime.setText("Running");
                        }
                    }
                    @Override
                    public void onFinish() {
                        startAlert();
                        countTime.setText("Alarm");
                        setTimer.setEnabled(true);
                    }
                }.start();
            }
        });

    }
    public void startAlert(){
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (1), pendingIntent);
    }



}

