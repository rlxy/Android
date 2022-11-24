package com.example.a21_create_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

// SQLiteOpenHelper这是一个抽象类，所以他的两个构造方法需要写出来(onCreate方法和onUpgrade方法)
public class DatabaseHelper extends SQLiteOpenHelper {
    private final Context mcontext;
    private static int DB_version = 1;
    // 在sqlite中有四种常用类型：integer整型，real浮点型，text文本型，blob二进制类型
    //primary key autoincrement代表主键是整型并且自动增长
    public static final String SQL = "create table stu(_id integer primary key autoincrement,name text,age text)";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,
                          int DB_version) {
        super(context, name, factory, DB_version);
        this.mcontext = context;
    }
😀second

    @Override
    //
    public void onCreate(SQLiteDatabase db) {
        //执行sqlite语句
        db.execSQL(SQL);
        Toast.makeText(mcontext, "创建数据库成功-------------------",Toast.LENGTH_SHORT).show();
    }

    public static int getDB_VERSION(){
        return DB_version;
    }
    public static void setDb_version(int db_version){
        DB_version = db_version;
        System.out.println("更新数据库成功！！！！！！");
        int oldversion = DatabaseHelper.getDB_VERSION();
        System.out.println("现版本数据库版本为："+oldversion);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL = "create table score(_id integer primary key autoincrement,math text,chinese text)";
        db.execSQL(SQL);
        Toast.makeText(mcontext, "更新数据库+++++++++++++++++++",Toast.LENGTH_SHORT).show();


    }
}
