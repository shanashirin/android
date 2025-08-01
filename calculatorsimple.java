package com.example.simple_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber;
    EditText editTextNumber2;
    Button button;
    Button button2;
    Button button3;
    Button button5;


    float sol = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button5 = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Float.parseFloat(editTextNumber.getText().toString());
                float b = Float.parseFloat(editTextNumber2.getText().toString());
                sol = a + b;
                Toast.makeText(MainActivity.this, "The sum is" + sol, Toast.LENGTH_SHORT).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Float.parseFloat(editTextNumber.getText().toString());
                float b = Float.parseFloat(editTextNumber2.getText().toString());
                sol = a - b;
                Toast.makeText(MainActivity.this, "The difference is" + sol, Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Float.parseFloat(editTextNumber.getText().toString());
                float b = Float.parseFloat(editTextNumber2.getText().toString());
                sol = a * b;
                Toast.makeText(MainActivity.this, "The product is" + sol, Toast.LENGTH_SHORT).show();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Float.parseFloat(editTextNumber.getText().toString());
                float b = Float.parseFloat(editTextNumber2.getText().toString());
                sol = a / b;
                Toast.makeText(MainActivity.this, "the divisor is" + sol, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
