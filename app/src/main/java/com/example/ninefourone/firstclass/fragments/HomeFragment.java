package com.example.ninefourone.firstclass.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.firstclass.R;
import com.example.ninefourone.firstclass.adapter.AnimalAdapter;
import com.example.ninefourone.firstclass.adapter.PagerAdapter;
import com.example.ninefourone.firstclass.bean.Animal;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private SlidingTabLayout slidingTabLayout;
    private CardView avatar;
    private DrawerLayout drawerLayout;

    @SuppressLint("ValidFragment")
    public HomeFragment(DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        viewPager = view.findViewById(R.id.home_view_pager);
        avatar = view.findViewById(R.id.avatar);


        pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        slidingTabLayout = view.findViewById(R.id.sliding_layout);
        slidingTabLayout.setViewPager(viewPager);

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!drawerLayout.isDrawerOpen(Gravity.START)){
                    drawerLayout.openDrawer(Gravity.START);
                }
            }
        });
        return view;
    }
}
