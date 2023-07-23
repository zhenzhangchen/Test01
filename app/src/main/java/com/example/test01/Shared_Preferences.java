package com.example.test01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Shared_Preferences extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedpreferences;
    private TextView name;
    private TextView age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        Button btn_save = findViewById(R.id.btn_save);
        Button btn_delete = findViewById(R.id.btn_delete);

        sharedpreferences = getSharedPreferences("My_config",MODE_PRIVATE);
        reload();
        btn_save.setOnClickListener(this);
        btn_delete.setOnClickListener(this);

    }
    protected void reload()
    {
        String username = sharedpreferences.getString("name", "");
        Log.d("username", username);
        int userage = sharedpreferences.getInt("age", 0);
        if(!username.equals(""))
        {
            name.setText(username);
        }
        if(userage!=0)
        {
            //注意这里不能直接age.setText(usrage)，会出错，系统会以为去找资源文件
            age.setText(String.valueOf(userage));
        }
        return;
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_save)
        {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString("name",name.getText().toString());
            editor.putInt("age",Integer.parseInt(age.getText().toString()));
            editor.apply();
        }
        if(v.getId()==R.id.btn_delete)
        {
            deleteinfo();
        }

    }
    protected void deleteinfo()
    {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.apply();
    }
}