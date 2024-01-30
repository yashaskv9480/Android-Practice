package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText num,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.edit_text_number);
        msg = findViewById(R.id.edit_text_msg);
    }
    public void sendsms(View view){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(num.getText().toString(),null,msg.getText().toString(),null,null);
            Snackbar.make(view,"Sms not send",Snackbar.LENGTH_LONG).show();

        }
        catch (Exception e){
            Snackbar.make(view,"Sms not send"+ e,Snackbar.LENGTH_LONG).show();
        }
    }
}