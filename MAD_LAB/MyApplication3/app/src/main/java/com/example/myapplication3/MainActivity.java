package com.example.myapplication3;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, email, password;
    RadioGroup genderGroup;
    CheckBox agree;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        genderGroup = findViewById(R.id.genderGroup);
        agree = findViewById(R.id.agree);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {

            String n = name.getText().toString().trim();
            String e = email.getText().toString().trim();
            String p = password.getText().toString().trim();

            if (n.isEmpty()) {
                name.setError("Enter your name");
                name.requestFocus();

            } else if (e.isEmpty()) {
                email.setError("Enter your email");
                email.requestFocus();

            } else if (!e.contains("@")) {
                email.setError("Enter a valid email");
                email.requestFocus();

            } else if (p.isEmpty()) {
                password.setError("Enter password");
                password.requestFocus();

            } else if (p.length() < 6) {
                password.setError("Password must be at least 6 characters");
                password.requestFocus();

            } else if (genderGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this,
                        "Select your gender",
                        Toast.LENGTH_SHORT).show();

            } else if (!agree.isChecked()) {
                Toast.makeText(this,
                        "Please agree to the terms and conditions",
                        Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this,
                        "Registration Successful",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
