package com.example.ninefourone.firstclass.fragments.homefragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.firstclass.R;
import com.example.ninefourone.firstclass.adapter.AnimalAdapter;
import com.example.ninefourone.firstclass.bean.Animal;

import java.util.ArrayList;

public class BirdFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Animal> animals = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bird_fragment, container, false);
        recyclerView = view.findViewById(R.id.bird_recycler_view);


        for (int i = 0; i < 10; i++) {
            Animal animal = new Animal("狗子", R.drawable.callme);
            animals.add(animal);
        }
        AnimalAdapter animalAdapter = new AnimalAdapter(animals, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(animalAdapter);
        return view;
    }
}
