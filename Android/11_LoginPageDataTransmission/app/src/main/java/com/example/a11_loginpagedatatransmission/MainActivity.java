package com.example.a11_loginpagedatatransmission;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText userID = findViewById(R.id.userID);
        EditText password = findViewById(R.id.password);
        Button btn_Login = findViewById(R.id.Button_Login);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.Button_Login) {
                    String getusername = userID.getText().toString();
                    String getpassword = password.getText().toString();
                    Intent intent = new Intent(MainActivity.this, LoginPage.class);
                    intent.putExtra("username", getusername);
                    intent.putExtra("password", getpassword);
                    startActivity(intent);
                }
            }
        });
    }
}