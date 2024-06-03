package com.example.checkboxsubject;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox android, java, python, cs, dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate views
        android = (CheckBox) findViewById(R.id.android);
        android.setOnClickListener(this);
        java = (CheckBox) findViewById(R.id.java);
        java.setOnClickListener(this);
        python = (CheckBox) findViewById(R.id.python);
        python.setOnClickListener(this);
        cs = (CheckBox) findViewById(R.id.cs);
        cs.setOnClickListener(this);
        dm = (CheckBox) findViewById(R.id.dm);
        dm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.android:
                if (android.isChecked())
                    Toast.makeText(getApplicationContext(), "You have selected Android", Toast.LENGTH_SHORT).show();
                break;
            case R.id.java:
                if (java.isChecked())
                    Toast.makeText(getApplicationContext(), "You have selected Java", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cs:
                if (cs.isChecked())
                    Toast.makeText(getApplicationContext(), "You have selected Computer Security", Toast.LENGTH_SHORT).show();
                break;
            case R.id.python:
                if (python.isChecked())
                    Toast.makeText(getApplicationContext(), "You have selected Python", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dm:
                if (dm.isChecked())
                    Toast.makeText(getApplicationContext(), "You have selected Data Mining", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}