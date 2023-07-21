package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.test01.util.ViewUtils;

public class Edittext extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        EditText id =findViewById(R.id.id);
        EditText password = findViewById(R.id.passwpord);
        id.addTextChangedListener(new HideTextWeather(id,11));
        password.addTextChangedListener(new HideTextWeather(password,6));

    }

    private class HideTextWeather implements TextWatcher {
        private int MaxLength;
        private EditText et;
        public HideTextWeather(EditText p0, int p1) {
            this.MaxLength = p1;
            this.et = p0;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String txt = s.toString();
            if(txt.length() == MaxLength)
            {
                ViewUtils.hideOneInputMethod(Edittext.this,et);
            }
        }
    }
}