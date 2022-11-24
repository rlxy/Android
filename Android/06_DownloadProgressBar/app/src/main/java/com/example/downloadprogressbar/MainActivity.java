package com.example.downloadprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //定义私有变量，前面是变量类型，后面是变量名
    private ImageView img;
    private Button btn;
    private ProgressBar horizontalBar;
    private ProgressBar circleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置所对应的xml文件
        setContentView(R.layout.activity_main);
        //找到并初始化所需控件
        img = findViewById(R.id.img);
        btn = findViewById(R.id.btn);
        horizontalBar = findViewById(R.id.horizontalBar);
        circleBar = findViewById(R.id.circleBar);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn:
                //设置图片
                img.setImageResource(R.drawable.downloading);
                //获得进度条进度
                int progress = horizontalBar.getProgress();
                //增加进度条进度
                progress += 10;
                //设置进度条进度
                horizontalBar.setProgress(progress);

                if (progress >= 100){
                    Toast.makeText(this,"下载完成",Toast.LENGTH_SHORT).show();
                    //重新加载新图片
                    img.setImageResource(R.drawable.end);
                    //移除圆形进度条
                    circleBar.setVisibility(View.INVISIBLE);
                    btn.setEnabled(false);
                    return;

                }
                break;
            default:
                break;
        }
    }
}