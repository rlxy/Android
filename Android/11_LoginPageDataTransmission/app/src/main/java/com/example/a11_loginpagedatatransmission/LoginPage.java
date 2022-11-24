package com.example.a11_loginpagedatatransmission;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        Intent data = getIntent();
        String userid = data.getStringExtra("username");
        String password = data.getStringExtra("password");
        TextView tvShow = findViewById(R.id.tvShow);
        tvShow.setText("登录成功!" + "\n账号是:" + userid + "\n密码是:" + password);
    }
}