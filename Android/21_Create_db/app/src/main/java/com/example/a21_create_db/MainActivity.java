package com.example.a21_create_db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper createdatabaseHelper;
    private final int CLICK_c = 1;
    private final int CLICK_u = 2;
    private final int CLICK_r = 3;
    private final int CLICK_d = 4;
    private final int CLICK_insert = 5;
    private final int CLICK_ut = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createdatabaseHelper = new DatabaseHelper(this, "1110.db",null,1);
        Button creadb = findViewById(R.id.createdb);
        creadb.setOnClickListener(this::onClick);
        creadb.setTag(CLICK_c);
        Button updata = findViewById(R.id.updatedb);
        updata.setOnClickListener(this::onClick);
        updata.setTag(CLICK_u);

        Button read = findViewById(R.id.readdata);
        read.setOnClickListener(this::onClick);
        read.setTag(CLICK_r);

        Button dele = findViewById(R.id.deletedata);
        dele.setOnClickListener(this::onClick);
        dele.setTag(CLICK_d);

        Button inser = findViewById(R.id.insertb);
        inser.setOnClickListener(this::onClick);
        inser.setTag(CLICK_insert);

        Button updatatb = findViewById(R.id.updatadata);
        updatatb.setOnClickListener(this::onClick);
        updatatb.setTag(CLICK_ut);


    }
    public void onClick(View view){
        // getReadableDatabase和getWritableDatabase方法都可以创建或打开一个数据库
//        databaseHelper.getWritableDatabase();
        //第一次点击按钮会自动检测是否存在这个数据库，没有的就执行onCreate方法，存在则不会运行
        int tag = (Integer)view.getTag();
        switch (tag) {
            case(CLICK_c):
                createdatabaseHelper.getReadableDatabase();
                System.out.println("创建成功");
                break;
            case(CLICK_u):
                int oldversion = DatabaseHelper.getDB_VERSION();
                System.out.println("之前版本数据库版本为："+oldversion);
                updatedb();
                break;
            case(CLICK_r):
                readdb();
                break;
            case(CLICK_insert):
                insert();
                break;
            case(CLICK_d):
                delete();
                break;
            case(CLICK_ut):
                updatadata();
                break;
        }
    }
    public void updatedb(){
        System.out.println("更新数据库");
        DatabaseHelper.setDb_version(2);
    }

    public void readdb(){
        System.out.println("查询数据库：");
        SQLiteDatabase writetable = createdatabaseHelper.getReadableDatabase();
        //query查询，1.表名，2.需要查询字段的列表，用字符串数组形式传入，null为所有字段(后面同理)，3.可以增添查询条件(和其他操作的条件类似都有占位符)，
        // 4.占位符的值，5和6.groupby和having就相当于select同名命令，7.排序方法
        Cursor cursor = writetable.query("stu",null,null,null,null,null,null);

        //cursor是每行的集合，move移动游标，(游标指向数据)，一般moveToNext用于循环
        while (cursor.moveToNext()){
            //getColumnIndexOrThrow:从零开始返回指定列名称，如果不存在将抛出IllegalArgumentException 异常。
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
            String  name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String  age = cursor.getString(cursor.getColumnIndexOrThrow("age"));
            Log.i("TAG",id + "" + name + "" + age);
        }
        //关闭游标，释放资源
        cursor.close();
    }

    public void delete(){
        System.out.println("删除数据");
        //获取数据库实例，每个实例都代表了一个数据库操作，通过这个实例可以进行增删查改
        SQLiteDatabase writetable = createdatabaseHelper.getWritableDatabase();
        //删除数据delete：1.表名，2.判断更新哪个字段名(?为占位符)，3.占位符的数据
        writetable.delete("stu","name=?",new String[]{"小路"});
    }

    public void insert(){
        EditText name = findViewById(R.id.sname);
        EditText age = findViewById(R.id.sage);
        String sname = name.getText().toString();
        String sage = age.getText().toString();
        System.out.println("插入数据");
        SQLiteDatabase writetable = createdatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", sname);
        values.put("age", sage);
        writetable.insert("stu",null,values);
    }
    public void updatadata(){
        System.out.println("更新表数据");
        SQLiteDatabase writetable = createdatabaseHelper.getWritableDatabase();
        //ContentValues实例包装了HashMap类,该类用于存储键值对的数据，每个键值对表示一列的列名和该列的数据
        ContentValues values = new ContentValues();
        //put用于向value变量存放一个键值对，value可以是基本类型，数组，对象的类型
        values.put("age","20");
        //1.表名，2.需要更新的值，3.以什么条件判断更新哪个字段4.条件字段占位符的值
        writetable.update("stu",values,"name=?",new String[]{"小路"});
    }

}
