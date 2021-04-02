package com.devaartem.roomreminder;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Selection extends AppCompatActivity {
    Button buttonVoice,buttonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        buttonVoice = (Button) findViewById(R.id.goToVoice);
        configureVoiceButton();
        buttonText = (Button) findViewById(R.id.goToText);
        buttonText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m= new Intent(Selection.this,TextReminder.class);
                startActivity(m);
            }
        });


    }
    private void configureVoiceButton(){

        buttonVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l= new Intent(Selection.this,MainActivity.class);
                startActivity(l);
            }
        });

    }
}