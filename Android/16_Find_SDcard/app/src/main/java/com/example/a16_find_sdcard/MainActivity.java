package com.example.a16_find_sdcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;
// 读写SD卡的时候每次都要判断SD卡是否存在，并且是否可读可写
// 从Android6.0开始，为了保护用户隐私，将一些权限放在程序运行的时候取申请，所以写SD需要运行时获取WRITE_EXTERNAL_STORAGE权限
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File SDpath = Environment.getExternalStorageDirectory();
        System.out.println("SD卡路径为：" + SDpath);
        judge();
        checkGrant();
    }


    private void judge() {

        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            System.out.println("SD卡存在，并有可读并可写权限");
        }else if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            System.out.println("SD卡存在，但只可读");
        }else {
            System.out.println("SD卡不存在");
        }
    }

    @SuppressLint("NewApi")
    private void checkGrant(){
        //判断是否授权
        if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //请求授权：参数一是要授权的权限放入String数组内，参数二是请求码
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else{
            System.out.println("已有权限，可直接处理读写");
        }
    }

    //授权结果返回
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //继承父类
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //判断请求是否得到授权
        if(requestCode == 1){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                System.out.println("请求授权成功");
            }
        }
    }
}