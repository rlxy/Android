package com.example.a14_savedata_01;

import android.app.Activity;
import android.content.Context;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Save {
    private Context mcontext;

    private void save(){
        String data = "this is string type of data";
        FileOutputStream out = null;

        //用异常处理来保存数据更利于检查错误
        try {
            out = mcontext.openFileOutput("file.txt",Context.MODE_PRIVATE);
            out.write(data.getBytes());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (out != null){
                    //数据存入后关闭文件
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
