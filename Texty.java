package com.devaartem.roomreminder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;

public class Texty extends AppCompatActivity {
    TextView editText;
    Button saveText,showText;
    String text;
    SharedPreferences myPrefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texty);
        editText=(TextView) findViewById(R.id.EditText1);
        saveText=(Button) findViewById(R.id.saveText);
        showText=(Button) findViewById(R.id.showText);

        showText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPrefs = getSharedPreferences("tasks", Context.MODE_PRIVATE);
                String printThis = myPrefs.getString("savedText","Error Saving");
                editText.setText(printThis, TextView.BufferType.EDITABLE);
            }
        });

        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                myPrefs = getSharedPreferences("tasks", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString("savedText", text);
                editor.apply();
                editor.commit();
                Intent j= new Intent(Texty.this,TextReminder.class);
                startActivity(j);
            }
            });
    }

    }