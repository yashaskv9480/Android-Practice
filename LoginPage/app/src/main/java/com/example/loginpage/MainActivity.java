package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText username,pass;
    Dbhandler db;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editText1);
        pass = findViewById(R.id.editText2);
        btn = findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pwd = pass.getText().toString();

                int id = checkuser(new User(uname,pwd));
                if(id == -1){
                    Snackbar.make(v,"User not valid" + uname ,Snackbar.LENGTH_LONG).show();
                }
                else {
                    Snackbar.make(v,"User login successful" + uname ,Snackbar.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(i);
                }
            }
        });

        db = new Dbhandler(MainActivity.this);
        db.addUser(new User("Yashas","123"));
        db.addUser(new User("demo","123"));

    }

    private int checkuser(User user) {

        return db.checkuser(user);
    }

}