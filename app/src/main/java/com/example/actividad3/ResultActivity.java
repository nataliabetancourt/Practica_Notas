package com.example.actividad3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private ConstraintLayout layout4;
    private TextView welcomeText, resultText;
    private Button calcAgainBtn;
    private String name, grade;
    private double finalGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Attributes
        layout4 = findViewById(R.id.layout4);
        welcomeText = findViewById(R.id.welcomeText);
        resultText = findViewById(R.id.resultText);
        calcAgainBtn = findViewById(R.id.calcAgainBtn);

        //Received by previous activity
        name = getIntent().getExtras().getString("name");
        finalGrade = getIntent().getExtras().getDouble("finalGrade");
        grade = String.format("%.2f", finalGrade);

        //Set name and final grade
        welcomeText.setText("Hola, " + name + ".\n Tu nota final es de:");
        resultText.setText(grade);

        //Button
        calcAgainBtn.setOnClickListener(
                (v) -> {
                    finish();
                }
        );

    }
}