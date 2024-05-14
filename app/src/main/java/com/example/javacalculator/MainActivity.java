package com.example.javacalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String currentNumber = "";
    private String operand = "";
    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        int[] buttonIds = {
                R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9
        };
        int[] operatorButtonIds = {
                R.id.buttonAdd, R.id.buttonSubtract, R.id.buttonMultiply, R.id.buttonDivide
        };

        for (int buttonId : buttonIds) {
            findViewById(buttonId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    currentNumber += buttonText;
                    updateTextView();
                }
            });
        }

        for (int operatorButtonId : operatorButtonIds) {
            findViewById(operatorButtonId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    operand = ((Button) v).getText().toString();
                    if (!currentNumber.isEmpty()) {
                        result = Double.parseDouble(currentNumber);
                        currentNumber = "";
                    }
                }
            });
        }

        findViewById(R.id.buttonEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentNumber.isEmpty()) {
                    double secondNumber = Double.parseDouble(currentNumber);
                    switch (operand) {
                        case "+":
                            result += secondNumber;
                            break;
                        case "-":
                            result -= secondNumber;
                            break;
                        case "*":
                            result *= secondNumber;
                            break;
                        case "/":
                            result /= secondNumber;
                            break;
                    }
                    currentNumber = "";
                    updateTextView();
                }
            }
        });
    }

    private void updateTextView() {
        textView.setText(currentNumber.isEmpty() ? String.valueOf(result) : currentNumber);
    }
}
