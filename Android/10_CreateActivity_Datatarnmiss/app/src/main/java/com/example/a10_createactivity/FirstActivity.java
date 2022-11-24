package com.example.a10_createactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = "admin";
                String password = "123123";
                Intent intent = new Intent(FirstActivity.this,secondActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
}