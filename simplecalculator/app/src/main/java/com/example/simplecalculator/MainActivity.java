
package com.example.simplecalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt_first, edt_second, edt_result;

    Button btn_add, btn_subtract, btn_multiply, btn_divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Find views
        edt_first = findViewById(R.id.edt_first);
        edt_second = findViewById(R.id.edt_second);
        edt_result = findViewById(R.id.edt_result);

        btn_add = findViewById(R.id.btn_add);
        btn_subtract = findViewById(R.id.btn_subtract);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_divide = findViewById(R.id.btn_divide);

        // Addition
        btn_add.setOnClickListener(v -> calculate("+"));

        // Subtraction
        btn_subtract.setOnClickListener(v -> calculate("-"));

        // Multiplication
        btn_multiply.setOnClickListener(v -> calculate("*"));

        // Division
        btn_divide.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operator) {

        String first = edt_first.getText().toString().trim();
        String second = edt_second.getText().toString().trim();

        // Check empty fields
        if (first.isEmpty()) {

            edt_first.setError("Enter first number");
            edt_first.requestFocus();

            return;
        }

        if (second.isEmpty()) {

            edt_second.setError("Enter second number");
            edt_second.requestFocus();

            return;
        }

        double num1 = Double.parseDouble(first);
        double num2 = Double.parseDouble(second);

        double result = 0;

        switch (operator) {

            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":

                if (num2 == 0) {

                    Toast.makeText(
                            MainActivity.this,
                            "Cannot divide by zero",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                result = num1 / num2;
                break;
        }

        edt_result.setText(String.valueOf(result));
    }
}


