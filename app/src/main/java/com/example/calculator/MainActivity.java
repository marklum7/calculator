package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstNumberEditText;
    EditText secondNumberEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    firstNumberEditText = findViewById(R.id.edit1);
                    secondNumberEditText = findViewById(R.id.edit2);
                    int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString());
                    int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString());
                    int result = firstNumber + secondNumber;
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("firstNumber", firstNumber);
                    intent.putExtra("secondNumber", secondNumber);
                    intent.putExtra("result", result);
                    startActivity(intent);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Введите корректные данные", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Ошибка: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
