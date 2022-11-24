package com.example.a19_login_lock_id;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences errortimedata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //账号变量
        EditText etusername = findViewById(R.id.etusername);
        EditText etpassword = findViewById(R.id.etpassword);
        EditText etrsusername = findViewById(R.id.etrsusername);
        EditText etrspassword = findViewById(R.id.etrspassword);

        //按钮变量
        Button logbtn = findViewById(R.id.btnLogin);
        Button rsbtn = findViewById(R.id.btnRegister);

        //登录框数据
        String userName = etusername.getText().toString();
        String passWord = etpassword.getText().toString();


        //注册框数据
        String reuserName = etrsusername.getText().toString();
        String repassWord = etrspassword.getText().toString();

        SharedPreferences account = getSharedPreferences("account", MODE_PRIVATE);

        //登录账户
//        boolean Loginedname = account.getBoolean(userName,false);
//        boolean Loginedpass = account.getBoolean(passWord,false);
        //测试变量
        final String[] Loginedname = {"root"};
        final String[] Loginedpass = {"123123"};
        final int[] time = {0};
        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(userName);
                System.out.println(passWord);
                time[0] = succend(Loginedname[0], Loginedpass[0], userName, passWord, time[0]);
            }
        });

//        rsbtn.setOnClickListener(Register(etrsusername, etrspassword));

    }

    // 登录检测
    //11月24号暂停问题：界面输入框获取的数据和理想数据不同，一直得不到理想结果
    public int succend(String Loginedname, String Loginedpass, String userName, String passWord, int time){
        System.out.println(userName + passWord);
        if (Objects.equals(userName, Loginedname) && Objects.equals(passWord, Loginedpass)){
                    Toast.makeText(this,"登录成功，---" + "账号是" + userName + ",密码是" + passWord, Toast.LENGTH_SHORT).show();
            }
        else if (!userName.equals(Loginedname) && !passWord.equals(Loginedpass)){
                time += 1;
                Toast.makeText(this, "登录错误-----"+"错误次数：" + time + ",达到三次则锁定账号", Toast.LENGTH_SHORT).show();
            }
        return time;
//        if (time == 3){
//            //错误三次，保存错误时间
//            SharedPreferences errortimedata = getSharedPreferences("mytimedata",MODE_PRIVATE);
//            SharedPreferences.Editor editor = errortimedata.edit();
//            long errorTime = errortimedata.getLong("errorTime",OL);
//            long rurrentTime = System.currentTimeMillis();
//            if(rurrentTime - errorTime > 30){
//                if (Loginedname && Loginedpass){
//                    String userName = etusername.getText().toString();
//                    String passWord = etpassword.getText().toString();
//                    Toast.makeText(this, "账号是" + userName + ",密码是" + passWord, Toast.LENGTH_SHORT).show();
//                }
//            }else{
//                Toast.makeText(this, "登录失败，现在禁止登录", Toast.LENGTH_SHORT).show();
//                long errortimedata = System.currentTimeMillis();
//            }
//
//        }

    }



//    //注册并存储账号
//    protected View.OnClickListener Register(EditText username, EditText password){
//        SharedPreferences rsaccount = getSharedPreferences("rsaccount",MODE_PRIVATE);
//        SharedPreferences.Editor editor = rsaccount.edit();
//    editor.putBoolean(String.valueOf(username),true);
//    editor.putBoolean(String.valueOf(password),true);
//    editor.apply();
//        return null;
//    }
}