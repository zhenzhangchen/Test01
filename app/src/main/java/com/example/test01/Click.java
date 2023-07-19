package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Click extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        tv = findViewById(R.id.text_view);
        Button btn = findViewById(R.id.btn_click);
        btn.setOnClickListener(new MyOnClickListener(tv));
    }

    static class MyOnClickListener implements View.OnClickListener{

        private final TextView tv;

        public MyOnClickListener(TextView tv) {
            this.tv = tv;
        }

        @Override
        public void onClick(View v) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String time = sdf.format(new Date());
            this.tv.setText(this.tv.getText()+time);
        }
    }
}