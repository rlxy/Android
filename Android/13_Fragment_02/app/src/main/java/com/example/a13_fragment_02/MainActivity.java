package com.example.a13_fragment_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn_add);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //创建或添加一个碎片实例
                    Fragment fragment = new right_activity();
                    //获取碎片管理类FragmentManager实例
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    //开启一个碎片事务
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    //添加或替换碎片
                    fragmentTransaction.replace(R.id.rightFragment,fragment);
                    //提交事务
                    fragmentTransaction.commit();
                }
            });
    }
}