package com.example.a17_sdsavedata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn_sava);
        judge();
        checkGrant();
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_sava) {
                    savaTOSD();
                }
            }
        });
    }


    // 判断SD卡状态
    private void judge() {

        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            System.out.println("SD卡存在，并有可读并可写权限");
        }else if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            System.out.println("SD卡存在，但只可读");
        }else {
            System.out.println("SD卡不存在");
        }
    }
    // 判断SD卡是否授权
    @SuppressLint("NewApi")
    private void checkGrant(){
        if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            System.out.println("请求权限");
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
        System.out.println("已有权限，可直接处理读写");
    }
    // SD卡权限授权
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //如果没有授权则请求授权，授权成功后运行保存文件函数
                savaTOSD();
                System.out.println("请求授权成功");
            }
        }
    }

    // 提供path利用自定义函数进行文件保存
    public void savaTOSD(){
        File path = Environment.getExternalStorageDirectory();
        System.out.println("SD卡位置为:" + path);
        String FilePath = path + "/xi.png";
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.xi);
        savaTOFile(FilePath,Bitmap.CompressFormat.PNG,bitmap);
    }

    // 保存到SD卡
    public void savaTOFile(String filepath, Bitmap.CompressFormat format, Bitmap bitmap) {
        try {
            File file = new File(filepath);
            //判断文件是否存在
            if (!file.exists()) {
                //文件不存在，创建文件
                try {
                    System.out.println("文件不存在，准备创建文件");
                    file.createNewFile();
                    System.out.println("文件创建成功");
                    System.out.println("开始保存文件");
                    FileOutputStream out = new FileOutputStream(file);
                    bitmap.compress(format, 100, out);
                    System.out.println("保存成功!-------------");
                    out.close();
                }catch (Exception e){
                    System.out.println("文件创建失败了！！！");
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
