package com.example.a14_savedata_01;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save();
        read();
    }
        private void save(){
            String datas = "this is string type of data";
            FileOutputStream out = null;
            //用异常处理来保存数据更利于检查错误
            try {
                out = openFileOutput("file.txt",MODE_PRIVATE);
                out.write(datas.getBytes());
                System.out.println("正在保存文件");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("出现异常");
            }finally {
                try {
                    if (out != null){
                        //数据存入后关闭文件
                        System.out.println("关闭文件");
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("出现异常");
                }
            }

        }

        private void read(){
            try {
                byte[] buff = new byte[1024];
                StringBuilder stringBuilder = new StringBuilder("");
                FileInputStream input = null;
                input = openFileInput("file.txt");
                int s = input.read(buff);
                    stringBuilder.append(new String(buff,0,s));
                input.close();
                String data = stringBuilder.toString();
                System.out.println("read data is :" + data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
