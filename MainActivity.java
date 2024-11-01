package com.example.javacalci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonDiv, buttonMul;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonDiv = findViewById(R.id.btn_div);
        buttonMul = findViewById(R.id.btn_mul);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answertxt);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
    }

    public int getIntfromEditText(EditText editText) {
        try {
            // Check if the EditText is empty or contains invalid input
            if (editText.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
                return 0;
            }
            return Integer.parseInt(editText.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input. Please enter a valid number.", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    @Override
    public void onClick(View view) {
        num1 = getIntfromEditText(editTextN1);
        num2 = getIntfromEditText(editTextN2);
        int id = view.getId();

        if (id == R.id.btn_add) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (id == R.id.btn_sub) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (id == R.id.btn_mul) {
            textView.setText("Answer = " + (num1 * num2));
        } else if (id == R.id.btn_div) {
            if (num2 == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show(); // if we divide any number with 0 it will show this text
                textView.setText("Error");
            } else {
                textView.setText("Answer = " + ((float) num1 / (float) num2));
            }
        }
    }
}
