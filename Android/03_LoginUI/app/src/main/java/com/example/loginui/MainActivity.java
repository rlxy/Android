package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etusername;
    private EditText etpassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        etusername = findViewById(R.id.etusername);
        etpassword = findViewById(R.id.etpassword);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btnLogin:
                String userName = etusername.getText().toString();
                String passWord = etpassword.getText().toString();
                Toast.makeText(this,"账号是" + userName + ",密码是" + passWord, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
    }
