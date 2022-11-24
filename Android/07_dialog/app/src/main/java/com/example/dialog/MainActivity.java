package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        //getId 获取v的id
        switch (v.getId()){
            case R.id.btn1:
                showSimpleAlertDialg();
                break;
            case R.id.btn2:
                showListDialog();
                break;
            default:
                break;
        }
    }

    private void showSimpleAlertDialg(){
        //创建对象
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        //对话框标题
        dialog.setTitle("提示：");
        //对话框内容
        dialog.setMessage("这是一个对话框");
        //禁止通过模拟器返回键取消
        dialog.setCancelable(false);
        //调用setPositive/Negative/NeutralButton()设置：确定，取消，中立按钮；
        dialog.setPositiveButton("确认", (dialogInterface, i) ->
                Toast.makeText(MainActivity.this,"你点击了确认按钮",Toast.LENGTH_SHORT).show());
        //第二个按钮
        dialog.setNegativeButton("取消",null);
        //调用show()方法将对话框显示出来
        dialog.show();
    }

    private void showListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("选择城市");
        final String[] cityes = {"北京", "上海", "广州", "香港", "澳门"};
        builder.setItems(cityes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "选择的城市为：" + cityes[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    }