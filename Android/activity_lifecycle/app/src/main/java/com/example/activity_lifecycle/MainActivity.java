package com.example.activity_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

//活动的生命周期
//1.第一次打开调用onCreate(),onStart(),onResume(),调用后允许和用户进行交互
//2.在模拟器回到桌面,程序调用onPause(),onStop(),此时活动进入后台，隐藏并不再可见
//3.用模拟器重写进入活动,程序调用onRestart(),onStart(),onResume(),
// 此时活动从后台重新变为可见，onCreate()不调用的原因是活动还在并没有销毁，不用重新调用
//4.最后退出程序,发现调用了onPause(),onStop(),onDestroy(),现在程序为销毁状态


public class MainActivity extends AppCompatActivity {
    private static final String TAG_log = "lifecycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG_log,"onCreate()已调用");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG_log,"onStart()已调用");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG_log,"onResume()已调用");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG_log,"onPause()已调用");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG_log,"onStop()已调用");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG_log,"onDestroy()已调用");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG_log,"onRestart()已调用");
    }
}