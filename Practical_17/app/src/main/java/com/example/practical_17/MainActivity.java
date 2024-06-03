package com.example.practical_17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name,Pass,delete;
    com.example.practical17_sqldb.myDbAdapter helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name= (EditText) findViewById(R.id.editName);
        Pass= (EditText) findViewById(R.id.editPass);
        delete = (EditText) findViewById(R.id.delete);

        helper = new com.example.practical17_sqldb.myDbAdapter(this);
    }
    public void addUser(View view)
    {
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        if(t1.isEmpty() || t2.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Enter Both Name and Password", Toast.LENGTH_LONG).show();
        }
        else
        {
            long id = helper.insertData(t1,t2);
            if(id<=0)
            {
                Toast.makeText(getApplicationContext(), "Insertion Unsuccessful", Toast.LENGTH_SHORT).show();
                Name.setText("");
                Pass.setText("");
            } else
            {
                Toast.makeText(getApplicationContext(), "Insertion Successful", Toast.LENGTH_SHORT).show();
                Name.setText("");
                Pass.setText("");
            }
        }
    }

    public void viewData(View view)
    {
        String data = helper.getData();
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
    }


    public void delete( View view)
    {
        String uname = delete.getText().toString();
        if(uname.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Enter username to delete the Record", Toast.LENGTH_SHORT).show();
        }
        else{
            int a= helper.delete(uname);
            if(a<=0)
            {
                Toast.makeText(getApplicationContext(), "username entered is not valid, deletion unsuccessful", Toast.LENGTH_SHORT).show();
                delete.setText("");
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Record Deleted", Toast.LENGTH_SHORT).show();
                delete.setText("");
            }
        }
    }
}
