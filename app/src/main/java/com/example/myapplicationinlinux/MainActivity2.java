package com.example.myapplicationinlinux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    Button b2,sp;
    EditText e1;
    TextView t1;
    TextToSpeech mtts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        t1=(TextView) findViewById(R.id.t1);
        e1=(EditText) findViewById(R.id.e1);
        sp=(Button) findViewById(R.id.sp);
        sp.setOnClickListener(view ->{
            t1.setText(" ");
            String text=e1.getText().toString();
            t1.setText(text);
            mtts.setLanguage(Locale.ENGLISH);
            mtts.setPitch(1f);
            mtts.setSpeechRate(0.5f);

            mtts.speak(text,TextToSpeech.QUEUE_FLUSH,null);

        });
        mtts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                Log.i("msg","ini");
            }
        });

        b2=(Button) findViewById(R.id.b2);
        b2.setOnClickListener(view ->{
            startActivity(new Intent(this,MainActivity.class));
        });
    }
}