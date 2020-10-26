package com.ftninformatika.termin_022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etText;
    private Button bStart;
    private Button bStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etText = findViewById(R.id.etText);
        bStart = findViewById(R.id.bStart);
        bStop = findViewById(R.id.bStop);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startMyService();
                startMyIntentService();
            }
        });


        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopMyService();
            }
        });
    }

    private void startMyService(){

        String msg = etText.getText().toString();
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra(MyService.MSG_TAG, msg);

        ContextCompat.startForegroundService(this, intent);

    }

    private void stopMyService(){

        Intent intent = new Intent(this, MyService.class);
        stopService(intent);

    }

    private void startMyIntentService(){

        String msg = etText.getText().toString();
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra(MyIntentService.MSG_TAG, msg);

        ContextCompat.startForegroundService(this, intent);

    }


}