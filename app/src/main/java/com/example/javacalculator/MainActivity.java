package com.example.javacalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @SuppressLint("MissingInflatedId")
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
            findViewById(Button.class, buttonId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    updateTextView(buttonText);
                }
            });
        }

        for (int operatorButtonId : operatorButtonIds) {
            findViewById(Button.class, operatorButtonId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String buttonText = ((Button) v).getText().toString();
                    updateTextView(" " + buttonText + " ");
                }
            });
        }
    }

    private Button findViewById(Class<Button> buttonClass, int buttonId) {
        return buttonClass.cast(findViewById(buttonId));
    }

    private void updateTextView(String text) {
        textView.append(text);
    }
}
