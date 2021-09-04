package com.example.actividad3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class ConfigActivity extends AppCompatActivity {

    private Button whiteBtn, grayBtn, blueBtn;
    private String whiteColor, grayColor, blueColor;
    private ConstraintLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        whiteBtn = findViewById(R.id.whiteBtn);
        grayBtn = findViewById(R.id.grayBtn);
        blueBtn = findViewById(R.id.blueBtn);
        layout2 = findViewById(R.id.layout3);

        //Color variables
        whiteColor = "#FFFFFF";
        grayColor = "#ABABAB";
        blueColor = "#C2F4F9";

        //Shared preferences
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);

        //Buttons
        whiteBtn.setOnClickListener(
                (v) -> {
                    data.edit().putString("background", whiteColor).apply();
                    finish();
                }
        );

        grayBtn.setOnClickListener(
                (v) -> {
                    data.edit().putString("background", grayColor).apply();
                    finish();
                }
        );

        blueBtn.setOnClickListener(
                (v) -> {
                    data.edit().putString("background", blueColor).apply();
                    finish();
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Change background
        SharedPreferences data = getSharedPreferences("data", MODE_PRIVATE);
        String background = data.getString("background", "#FFFFFF");
        layout2.setBackgroundColor(Color.parseColor(background));
    }
}