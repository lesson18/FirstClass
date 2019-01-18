package com.example.ninefourone.firstclass.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ninefourone.firstclass.R;
import com.example.ninefourone.firstclass.bean.Animal;

public class AnimalHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView textView;

    public AnimalHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.animal_image);
        textView = itemView.findViewById(R.id.animal_name);
    }
    public void bindView(Animal animal){
        imageView.setImageResource(animal.getImage());
        textView.setText(animal.getName());
    }
}
