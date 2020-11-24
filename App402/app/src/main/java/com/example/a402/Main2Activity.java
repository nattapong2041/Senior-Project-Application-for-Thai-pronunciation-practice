package com.example.a402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    public static int currentLevel = 0;
    public static int currentWord = 0;
    public static double totalScore = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_app);
    }

    public void startTest(View view){
        Intent intent = new Intent( Main2Activity.this, ShowWordActivity.class);
        startActivity(intent);
        totalScore = 0.00;
        finish();
    }

    public void changeLevel(View view){
        Intent intent = new Intent(Main2Activity.this, ChangeLevelActivity.class);
        startActivity(intent);
        finish();
    }

    public void history(View view){
        Intent intent = new Intent(Main2Activity.this, HistoryActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view){
        finish();
        System.exit(0);
    }
}
