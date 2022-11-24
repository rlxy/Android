// 适配器
package com.example.a08_recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    //FruitAdapter.ViewHolder是定义的一个内部类，继承自ViewHoider

    //定义了一个List<fruit>集合,并在FruitAdapter构造函数中传递进数据
    //final:表示最终,完结,可以成为完成器,表示对象为最终形态,不可以被更改,此时也可以称这个变量为常量了
    private final List<Fruit> mFruitList;

    //定义一个ViewHolder类，继承于RecyclerView.ViewHolder
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView  fruitImage;
        TextView fruitName;

        //在构造函数中传入View,这个view是RecyclerView子项最外层布局(fruit_item.xml中的LinearLayout)
        //通过这个最外层布局可以获取到子布局中的imageView和TextView
        ViewHolder(View view){
            super(view);
            fruitImage = itemView.findViewById(R.id.fruit_img);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }


    //下面是三继承RecyclerView.Vdapter必须要重写的三个方法
    // onCreateViewHolder：用于创建ViewHolder实例。这个方法将子项布局fruit_item加载进来并传入ViewHolder的构造函数，最后返回ViewHolder对象
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    // onBindViewHolder：用于对子项的数据进行赋值，在每个子项滚动到屏幕内的时候执行
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    // getItemCount：用于返回RecyclerView的长度
    public int getItemCount() {
        return mFruitList.size();
    }

    //构造函数，传递数据
    public FruitAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

}
