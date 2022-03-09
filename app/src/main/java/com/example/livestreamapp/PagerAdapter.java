package com.example.livestreamapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.*;


public class PagerAdapter extends FragmentStateAdapter {


    private ArrayList<Fragment> fragment_list;

    public PagerAdapter(@NonNull FragmentManager fragmentManager,
                        @NonNull Lifecycle lifecycle,
                        ArrayList<Fragment> list){
        super(fragmentManager, lifecycle);
        fragment_list = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position){
        Fragment vf = fragment_list.get(position);
        return vf;
    }

    @Override
    public int getItemCount() {
       return fragment_list.size();

    }


}
