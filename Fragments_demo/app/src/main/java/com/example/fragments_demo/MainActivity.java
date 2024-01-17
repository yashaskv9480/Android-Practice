package com.example.fragments_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Fragment_one fragmentOne = new Fragment_one();
    fragment_two fragmentTwo = new fragment_two();
    int showing = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.clayout, fragmentOne);
        showing = 1;
        fragmentTransaction.commit();
    }
        public void switchfragment(View view){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if(showing == 1){
                fragmentTransaction.add(R.id.clayout, fragmentTwo);
                showing = 1;
                fragmentTransaction.commit();
            }
            else{
                fragmentTransaction.add(R.id.clayout, fragmentOne);
                showing = 1;
                fragmentTransaction.commit();
            }
        }


}