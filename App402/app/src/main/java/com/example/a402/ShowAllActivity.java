package com.example.a402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileOutputStream;

public class ShowAllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_all);

        if(Main2Activity.currentLevel == 2){
            ((Button)findViewById(R.id.next_level)).setEnabled(false); ;
        }
        ((TextView) findViewById(R.id.test_level_at)).setText("แบบฝึกหัดชุดที่ "+(Main2Activity.currentLevel+1));
        ((TextView) findViewById(R.id.my_point)).setText("" + Main2Activity.totalScore +"/100 คะแนน");
        if(Main2Activity.currentLevel == 0){
            writeFile("historyLevel1.txt");
        }
        else if(Main2Activity.currentLevel == 1){
            writeFile("historyLevel2.txt");
        }
        else if(Main2Activity.currentLevel == 2){
            writeFile("historyLevel3.txt");
        }
    }

    public void writeFile(String filename){
        String string = ""+ Main2Activity.totalScore;
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main2Activity.currentWord = 0;
        Main2Activity.totalScore = 0;
    }
    public void retry(View view){
        Intent intent = new Intent( ShowAllActivity.this, ShowWordActivity.class);
        startActivity(intent);
        finish();
    }

    public void nextLevel(View view){
        Main2Activity.currentLevel  += 1;
        Intent intent = new Intent( ShowAllActivity.this, ShowWordActivity.class);
        startActivity(intent);
        finish();
    }

    public void home(View view){
        Intent intent = new Intent( ShowAllActivity.this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
