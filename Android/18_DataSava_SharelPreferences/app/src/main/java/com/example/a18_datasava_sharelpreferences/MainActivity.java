package com.example.a18_datasava_sharelpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image = (ImageView) findViewById(R.id.img);
        //获取对象，参数一是存储位置，参数二是存储模式
        sp = getSharedPreferences("check",MODE_PRIVATE);
        //从对象中获取数据，参数一是返回key键所对应的数据，参数二是默认返回值
        boolean isLogined = sp.getBoolean("LOGIN", false);
        if (!isLogined){
            //没登陆过则显示newperson图片
            image.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.newperson));
        }else {
            //否则显示old图片
            image.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.old));
        }
        savauser();
    }

    //数据写入到："data/data/程序包名/shared_prefs"里面
    protected void savauser(){
        //获取对象
        SharedPreferences.Editor editor = sp.edit();
        //准备往对象写入数据，参数一是键，参数二是值
        //注意存储的数据类型，所使用的存储类型不一样
        editor.putBoolean("LOGIN",true);
        // commit会立即写入存储，而apply则在后台运行
//        editor.commit()
        editor.apply();
        System.out.println("chunchucg");
    }
    }
