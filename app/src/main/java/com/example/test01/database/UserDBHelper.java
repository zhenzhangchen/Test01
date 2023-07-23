package com.example.test01.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuWrapperICS;

import com.example.test01.entity.User;

public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "user.db";
    private static final int DB_VERSION = 1;

    private static  UserDBHelper mHelper=null;

    private SQLiteDatabase mRDB = null;
    private SQLiteDatabase mWDB = null;

    private UserDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    // 单例模式,获取数据库唯一对象
    public static UserDBHelper getInstance(Context context)
    {
        if(mHelper == null)
        {
            mHelper = new UserDBHelper(context);
        }
        return mHelper;
    }
    // 数据库读连接
    public SQLiteDatabase openReadLink(){
        if(mRDB == null || !mRDB.isOpen())
        {
            mRDB = mHelper.getReadableDatabase();
        }
        return mRDB;
    }
    // 数据库写连接
    public SQLiteDatabase openWriteLink(){
        if(mWDB==null || !mWDB.isOpen())
        {
            mWDB = mHelper.openWriteLink();
        }
        return mWDB;
    }
    // 关闭数据库连接
    public void closeLink() {
        if (mRDB != null && mRDB.isOpen()) {
            mRDB.close();
            mRDB = null;
        }
        if (mWDB != null && mWDB.isOpen()) {
            mWDB.close();
            mWDB = null;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(User user)
    {
        ContentValues values = new ContentValues();
        values.put("name",user.getName());
        values.put("age",user.getAge());
        // 返回行号
        return mWDB.insert(DB_NAME,null,values);
    }
}
