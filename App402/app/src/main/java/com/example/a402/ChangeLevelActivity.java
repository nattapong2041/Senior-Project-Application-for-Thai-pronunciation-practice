package com.example.a402;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class ChangeLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_level);

        if(Main2Activity.currentLevel == 0){
            ((RadioButton) findViewById(R.id.radioButton1)).setChecked(true);
        }
        else if(Main2Activity.currentLevel == 1){
            ((RadioButton) findViewById(R.id.radioButton2)).setChecked(true);
        }
        else if(Main2Activity.currentLevel == 2){
            ((RadioButton) findViewById(R.id.radioButton3)).setChecked(true);
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    Main2Activity.currentLevel = 0;
                    break;
            case R.id.radioButton2:
                if (checked)
                    Main2Activity.currentLevel = 1;
                    break;
            case R.id.radioButton3:
                if (checked)
                    Main2Activity.currentLevel = 2;
                    break;
        }
    }

    public void home(View view){
        Intent intent = new Intent( ChangeLevelActivity.this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
}
