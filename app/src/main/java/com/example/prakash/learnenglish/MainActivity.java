package com.example.prakash.learnenglish;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import android.view.View;
import android.widget.Button;

import java.util.Locale;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextToSpeech t1;
    TextToSpeech t2;
   // EditText ed1;
    TextView tv1;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  ed1=(EditText)findViewById(R.id.editText);
        tv1 = findViewById(R.id.textforme);

        b1= findViewById(R.id.button);
        b2= findViewById(R.id.button2);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String toSpeak = ed1.getText().toString();
                String  toSpeak = tv1.getText().toString();

                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        t2=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t2.setLanguage(Locale.UK);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String toSpeak = ed1.getText().toString();
                  String toSpeak = tv1.getText().toString();

                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        if(t2 !=null){
            t2.stop();
            t2.shutdown();
        }
        super.onPause();
    }
}