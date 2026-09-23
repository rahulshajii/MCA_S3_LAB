package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e_name, e_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_name = findViewById(R.id.edt_name);
        e_pwd = findViewById(R.id.edt_passwd);
    }

    public void onclick(View view) {
        String s1=e_name.getText().toString();
        String s2=e_pwd.getText().toString();
        if(s1.equals("MCA") && s2.equals("mca"))
        {
            Toast.makeText(this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }
}