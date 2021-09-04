package com.example.actividad3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button configBtn, continueBtn;
    private EditText nameText;
    private ConstraintLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configBtn = findViewById(R.id.configBtn);
        continueBtn = findViewById(R.id.continueBtn);
        nameText = findViewById(R.id.nameText);
        layout1 = findViewById(R.id.layout1);

        //Buttons
        configBtn.setOnClickListener(
                (v) -> {
                    //Open config activity
                    Intent configActivity = new Intent(this, ConfigActivity.class);
                    startActivity(configActivity);
                }
        );

        continueBtn.setOnClickListener(
                (v) -> {
                    String name = nameText.getText().toString();

                    //Open calculation Activity
                    Intent calculationActivity = new Intent(this, CalculationActivity.class);
                    calculationActivity.putExtra("name", name);
                    startActivity(calculationActivity);
                    nameText.getText().clear();
                }
        );

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Change background
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);
        String background = data.getString("background", "#FFFFFF");
        layout1.setBackgroundColor(Color.parseColor(background));
    }
}