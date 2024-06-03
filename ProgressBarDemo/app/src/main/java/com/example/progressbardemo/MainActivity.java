package com.example.progressbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    EditText numberInput;
    Button submit;
    Handler handler=new Handler();
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        numberInput = (EditText) findViewById(R.id.number_input);
        submit = (Button) findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String progress=numberInput.getText().toString();
                progressBar.setProgress(Integer.parseInt(progress));

                a=progressBar.getProgress();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(a<100){
                            a+=1;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(a);
                                }
                            });
                            try{
                                Thread.sleep(100);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();


            }
        });
    }

}