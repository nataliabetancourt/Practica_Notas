package com.example.actividad3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculationActivity extends AppCompatActivity {

    private ConstraintLayout layout3;
    private EditText project1, project2, quiz, exam1, exam2;
    private Button calculateBtn;
    private String name;
    private double project1D, project2D, quizD, exam1D, exam2D, finalGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        project1 = findViewById(R.id.project1);
        project2 = findViewById(R.id.project2);
        quiz = findViewById(R.id.quiz);
        exam1 = findViewById(R.id.exam1);
        exam2 = findViewById(R.id.exam2);
        calculateBtn = findViewById(R.id.calculateBtn);
        layout3 = findViewById(R.id.layout3);

        //Name from main screen
        name = getIntent().getExtras().getString("name");



        calculateBtn.setOnClickListener(
                (v) -> {

                    try {
                    //Turning answers to int
                    project1D = Double.parseDouble(project1.getText().toString());
                    project2D = Double.parseDouble(project2.getText().toString());
                    quizD = Double.parseDouble(quiz.getText().toString());
                    exam1D = Double.parseDouble(exam1.getText().toString());
                    exam2D = Double.parseDouble(exam2.getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Por favor escribe números", Toast.LENGTH_SHORT).show();
                    }

                    //Final grade
                    finalGrade = ((project1D*0.20) + (project2D*0.20) + (quizD*0.20) + (exam1D*0.20) + (exam2D*0.20));

                    Intent resultActivity = new Intent(this, ResultActivity.class);
                    resultActivity.putExtra("finalGrade", finalGrade);
                    startActivity(resultActivity);
                }
        );
    }


    @Override
    protected void onResume() {
        super.onResume();

        //Change background
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);
        String background = data.getString("background", "#FFFFFF");
        layout3.setBackgroundColor(Color.parseColor(background));
    }
}