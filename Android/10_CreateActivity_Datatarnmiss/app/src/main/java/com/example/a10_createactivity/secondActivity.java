package com.example.a10_createactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        String pass = intent.getStringExtra("password");
        TextView tvShow = findViewById(R.id.tvShow);
        tvShow.setText("接收到FirstActivity数据：\nusername = " + name + "\npassword = " + pass);
    }
}