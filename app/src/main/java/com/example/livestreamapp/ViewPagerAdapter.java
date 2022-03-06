package com.example.livestreamapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>{
    private List<String> titles = new ArrayList<>();
    public ViewPagerAdapter(){
        titles.add("美女A");
        titles.add("美女B");
        titles.add("比老师直播间");
        titles.add("好耶");
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pager, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        try {
            holder.mTV.setText(titles.get(position%titles.size()));
        }catch (Exception e){

        }
    }

    @Override
    public int getItemCount() {
        return 10000;
    }

    class ViewPagerViewHolder extends RecyclerView.ViewHolder{

        TextView mTV;
        RelativeLayout mContainer;
        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            mContainer = itemView.findViewById(R.id.container);
            mTV = itemView.findViewById(R.id.tvTitle);
        }
    }
}
