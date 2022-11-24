package com.example.a08_recycler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        //RecyclerView:实现数据的纵向滚动, 定位xml文件里面预设的滚动控件
        RecyclerView recyclerView = findViewById(R.id.recycler);

        //RecyclerView 将所有的显示规则交给一个叫 LayoutManager 的抽象类去完成
        //StaggeredGridLayoutManager为网格布局
        //创建一个线性布局管理器对象，第一个参数spanCount，第二个参数为设置布局方向，水平or竖直
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL);
        //设置显示规则
        recyclerView.setLayoutManager(layoutManager);

        //适配器加入内容,FruitAdapter:提前写好的适配器
        FruitAdapter adapter = new FruitAdapter(fruitList);
        //setAdapter:设置适配器内的内容
        recyclerView.setAdapter(adapter);
    }

    //初始化水果数据,把数据加入fruitList列表中
    private void initFruits(){
            Fruit apple = new Fruit("Apple",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit cherry = new Fruit("Cherry",R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit grape = new Fruit("Grape",R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit mango = new Fruit("Mango",R.drawable.mango_pic);
            fruitList.add(mango);
            Fruit orange = new Fruit("Orange",R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit pear = new Fruit("Pear",R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit pineapple = new Fruit("Pineapple",R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry",R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit watermelon = new Fruit("Watermelon",R.drawable.watermelon_pic);
            fruitList.add(watermelon);

    }
}