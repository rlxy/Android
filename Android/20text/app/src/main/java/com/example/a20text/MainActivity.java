package com.example.a20text;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static int t = 0;
    private final int CLICK_LOG = 1;
    private final int CLICK_REG = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button logbtn = this.findViewById(R.id.btnLogin);
        Button regbtn = this.findViewById(R.id.btnRegister);
        logbtn.setOnClickListener(this::onClick);
        logbtn.setTag(CLICK_LOG);
        regbtn.setOnClickListener(this::onClick);
        regbtn.setTag(CLICK_REG);

    }

    public void onClick(View view){
        int tag = (Integer) view.getTag();
        System.out.println("点击了按钮");
        switch (tag){
            case CLICK_LOG:
                System.out.println("logloglog");
                final EditText etusername = findViewById(R.id.etusername);
                final EditText etpassword = findViewById(R.id.etpassword);
                String userName = etusername.getText().toString();
                String passWord = etpassword.getText().toString();
                detection(userName, passWord);
                break;
            case CLICK_REG:
                System.out.println("regregreg");
                final EditText reusername = findViewById(R.id.rsusername);
                final EditText repassword = findViewById(R.id.rspassword);
                String reguser = reusername.getText().toString();
                String regpass = repassword.getText().toString();
                System.out.println("name=" + reguser + "pass" + regpass);
                register(reguser,regpass);
                break;
        }

    }

    //用户账号检测
    protected void detection(String username, String password) {
        if (Objects.equals(username, "root") & Objects.equals(password, "123123")) {
            Toast.makeText(this, "账号是" + username + ",密码是" + password, Toast.LENGTH_SHORT).show();
        } else{
            t += 1;
            Toast.makeText(this, "错误次数:" + t, Toast.LENGTH_SHORT).show();
            if(t >= 3){
                Toast.makeText(this, "登录失败三次", Toast.LENGTH_SHORT).show();
            }
        }
        }

    //注册
    protected void register(String name,String word){
        Toast.makeText(this, "注册账号是" + name + ",注册密码是" + word, Toast.LENGTH_SHORT).show();
    }


    }


