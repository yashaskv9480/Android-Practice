package com.example.alertandprogressivebar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ProgressBar bar;
    TextView tv;

    int progressstatus = 0;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        bar = findViewById(R.id.progressBar);
        tv = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Hello");
                builder.setPositiveButton("Accept",((dialog, which) -> {
                    finish();
                }));
                builder.setNeutralButton("Cancel",(dialog, which) -> {
                    dialog.cancel();
                });
                builder.setMessage("are you sure");
                builder.setCancelable(false);
                builder.setIcon(R.drawable.number_2);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressstatus < 100){
                    progressstatus += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            bar.setProgress(progressstatus);
                            tv.setText(progressstatus);
                        }
                    });
                    try{
                        Thread.sleep(200);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}