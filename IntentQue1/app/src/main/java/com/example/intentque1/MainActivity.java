package com.example.intentque1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void browser1(View view){
        EditText url =  findViewById(R.id.editTextUrl);
        String textUrl = url.getText().toString();
        Log.d("TAG", textUrl);
        if (textUrl.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please Enter URl", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent brInt=new Intent(Intent.ACTION_VIEW, Uri.parse(textUrl));
        startActivity(brInt);
    }
}