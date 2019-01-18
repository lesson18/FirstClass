package com.example.ninefourone.firstclass.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ninefourone.firstclass.fragments.homefragments.BaoFragment;
import com.example.ninefourone.firstclass.fragments.homefragments.BirdFragment;
import com.example.ninefourone.firstclass.fragments.homefragments.DogFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private String[] titles = {"狗", "鸟", "鲍"};
    private Fragment[] fragments;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new Fragment[titles.length];
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null) {
            switch (position) {
                case 0:
                    fragments[position] = new DogFragment();
                    break;
                case 1:
                    fragments[position] = new BirdFragment();
                    break;
                case 2:
                    fragments[position] = new BaoFragment();
                    break;
            }
        }
        return fragments[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
