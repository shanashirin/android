package com.example.validation;

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

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editTextText3;
    EditText editTextNumber2;
    EditText editTextPhone2;
    EditText editTextTextPassword2;
    Button button;
    
    Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z][\\w{5,30}$");
    Pattern PASSWORD_PATTERN = Pattern.compile("^" +
            "(?=.*[0-9])" +         // at least 1 digit
            "(?=.*[a-z])" +         // at least 1 lower case letter
            "(?=.*[A-Z])" +         // at least 1 upper case letter
            "(?=.*[@#$%^&+=])" +    // at least 1 special character
            ".{4,}" +               // at least 4 characters
            "$");
    
    Pattern AGE_PATTERN = Pattern.compile("^" +
            "(?=\\S+$)" +           // no white spaces
            "[0-9]{1,2}" +          // 2 numbers
            "$");
    
    Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{7-9}[0-9]{9}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        editTextText3 = findViewById(R.id.editTextText3);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextPhone2 = findViewById(R.id.editTextPhone2);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        button = findViewById(R.id.button);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inpName = editTextText3.getText().toString();
                String inpAge = editTextNumber2.getText().toString();
                String inpPh = editTextPhone2.getText().toString();
                String inpPass = editTextTextPassword2.getText().toString();
                
                if (inpName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Name field is empty", Toast.LENGTH_SHORT).show();
                }
                if (inpAge.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Age field is Empty",
                            Toast.LENGTH_SHORT).show();
                }
                if (inpPh.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Phone field is Empty",
                            Toast.LENGTH_SHORT).show();
                }
                if (inpPass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pass field is Empty",
                            Toast.LENGTH_SHORT).show();
                }
                if (!USERNAME_PATTERN.matcher(inpName).matches()) {
                    editTextText3.setError("Enter alphabets [6-30 characters]");
                }
                if (!AGE_PATTERN.matcher(inpAge).matches()) {
                    editTextNumber2.setError("Incorrect Age");
                }
                if (!PHONE_PATTERN.matcher(inpPh).matches()) {
                    editTextPhone2.setError("should contain 10 digits");
                }
                if (!PASSWORD_PATTERN.matcher(inpPass).matches()) {
                    editTextTextPassword2.setError("Password is too weak");
                } else {
                    Toast.makeText(MainActivity.this, "Success",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
