package com.example.practical18_mysql_update_serach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practical_18.R;

public class MainActivity extends AppCompatActivity {
    EditText Name,Pass,updateold,updatenew;
    com.example.practical18_mysql_update_serach.myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name= (EditText) findViewById(R.id.editName);
        Pass= (EditText) findViewById(R.id.editPass);
        updateold = (EditText) findViewById(R.id.old_name);
        updatenew = (EditText) findViewById(R.id.new_name);

        helper = new com.example.practical18_mysql_update_serach.myDbAdapter(this);
    }
    public void addUser(View view)
    {
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        if(t1.isEmpty() || t2.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Enter Both username and Password", Toast.LENGTH_LONG).show();
        }
        else
        {
            long id = helper.insertData(t1,t2);
            if(id<=0)
            {
                Toast.makeText(getApplicationContext(), "Insertion Unsuccessful", Toast.LENGTH_LONG).show();
                Name.setText("");
                Pass.setText("");
            } else
            {
                Toast.makeText(getApplicationContext(), "Insertion Successful", Toast.LENGTH_LONG).show();
                Name.setText("");
                Pass.setText("");
            }
        }
    }

    public void viewData(View view)
    {
        String data = helper.getData();
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
    }


    public void update( View view)
    {
        String u1 = updateold.getText().toString();
        String u2 = updatenew.getText().toString();
        if(u1.isEmpty() || u2.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Enter data", Toast.LENGTH_LONG).show();
        }
        else
        {
            int a= helper.updateName( u1, u2);
            if(a<=0)
            {
                Toast.makeText(getApplicationContext(), "Unsuccessful", Toast.LENGTH_LONG).show();
                updateold.setText("");
                updatenew.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                updateold.setText("");
                updatenew.setText("");
            }
        }

    }
}
