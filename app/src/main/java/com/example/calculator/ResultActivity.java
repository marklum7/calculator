package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {
    private TextView mResultTextView;
    String resultString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        int firstNumber = 0;
        int secondNumber = 0;
        int result = 0;
        try {
            firstNumber = intent.getIntExtra("firstNumber", 0);
            secondNumber = intent.getIntExtra("secondNumber", 0);
            result = intent.getIntExtra("result", 0);
        } catch (NullPointerException e) {
            Log.e("ResultActivity", "Intent is null or extras are missing");
        }

        mResultTextView = findViewById(R.id.result);
        String resultString = "";
        if (firstNumber < 0 && secondNumber < 0) {
            resultString = "(" + firstNumber + ")" + " + " + "(" + secondNumber + ")" + " = " + result;
        } else if (firstNumber < 0) {
            resultString = "(" + firstNumber + ")" + " + " + secondNumber + " = " + result;
        } else if (secondNumber < 0) {
            resultString = firstNumber + " + " + "(" + secondNumber + ")" + " = " + result;
        } else {
            resultString = firstNumber + " + " + secondNumber + " = " + result;
        }

        mResultTextView.setText(resultString);
    }
}