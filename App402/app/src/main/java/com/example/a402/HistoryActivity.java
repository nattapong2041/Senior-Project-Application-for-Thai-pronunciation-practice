 package com.example.a402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;

 public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history2);

        loadFile("historyLevel1.txt");
        loadFile("historyLevel2.txt");
        loadFile("historyLevel3.txt");
    }

     public void loadFile(String filename){
         String inputString;
         try {
             BufferedReader inputReader = new BufferedReader(
                     new InputStreamReader(openFileInput(filename)));
             StringBuffer stringBuffer = new StringBuffer();
             while ((inputString = inputReader.readLine()) != null) {
                 stringBuffer.append(inputString + "\n");
             }
             if(filename.equals("historyLevel1.txt"))
                 ((TextView)findViewById(R.id.level_1score)).setText(stringBuffer.toString());
             else if(filename.equals("historyLevel2.txt"))
                 ((TextView)findViewById(R.id.level_2score)).setText(stringBuffer.toString());
             else if(filename.equals("historyLevel3.txt"))
                 ((TextView)findViewById(R.id.level_3score)).setText(stringBuffer.toString());
         }
         catch (Exception e) {
             e.printStackTrace();
             if(filename.equals("historyLevel1.txt"))
                 ((TextView)findViewById(R.id.level_1score)).setText("ยังไม่มีประวัติ");
             else if(filename.equals("historyLevel2.txt"))
                ((TextView)findViewById(R.id.level_2score)).setText("ยังไม่มีประวัติ");
             else if(filename.equals("historyLevel3.txt"))
                 ((TextView)findViewById(R.id.level_3score)).setText("ยังไม่มีประวัติ");
         }
     }

     public void home(View view){
         Intent intent = new Intent( HistoryActivity.this, Main2Activity.class);
         startActivity(intent);
         finish();
     }
}
