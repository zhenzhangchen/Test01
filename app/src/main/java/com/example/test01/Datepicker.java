package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class Datepicker extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private TextView res;
    private TextView date;
    private DatePicker dp;
    private Button btn;
    private Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        ok =  findViewById(R.id.btn_ok);
        dp = findViewById(R.id.date_picker);
        res = findViewById(R.id.tv_res);
        date = findViewById(R.id.tv_date);
        btn = findViewById(R.id.btn_choosedate);


        ok.setOnClickListener(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_ok)
        {
            String desc = String.format("%s年%s月%s日",dp.getYear(),dp.getMonth(),dp.getDayOfMonth());
            res.setText(desc);
        }
        if(v.getId() == R.id.btn_choosedate)
        {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            // 后面设置默认打开日历时间
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, 2021, month, 2);
            datePickerDialog.show();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Log.d("taggg", "onDateSet: ");
        String desc = String.format("您选择的日期是%d年%d月%d日",year,month+1,dayOfMonth);
        date.setText(desc);

    }
}