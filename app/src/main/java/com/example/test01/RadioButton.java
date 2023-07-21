package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.test01.R;

public class RadioButton extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        RadioGroup rg = findViewById(R.id.radio_group);

        tx = findViewById(R.id.sex);
        rg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(checkedId == R.id.radio_male)
        {
            tx.setText("你是帅哥");
        }
        else{
            tx.setText("你是美女");
        }
    }
}