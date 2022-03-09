package com.example.livestreamapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.*;


public class MainActivity extends AppCompatActivity implements VideoFragment1.CallBackValue1,
                                                               VideoFragment2.CallBackValue2,
                                                               VideoFragment3.CallBackValue3,
                                                               GiftFragment.GiftCallBackValue {

    ViewPager2 vp2;
    ArrayList<Fragment> frag_list;

    VideoFragment1 vf1;
    VideoFragment2 vf2;
    VideoFragment3 vf3;
    int cur_index;
    Fragment gf;

    TextView debug_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPager();

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        debug_txt = findViewById(R.id.debug_txt);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                updateLikes();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                initGiftFragment();
            }
        });

    }


    private void initPager(){

        vf1 = new VideoFragment1();
        vf2 = new VideoFragment2();
        vf3 = new VideoFragment3();
        frag_list = new ArrayList<>();

        frag_list.add(vf1);
        frag_list.add(vf2);
        frag_list.add(vf3);

        vp2 = findViewById(R.id.viewPager);
        vp2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        PagerAdapter vpa = new PagerAdapter(getSupportFragmentManager(),getLifecycle(),frag_list);
        vp2.setAdapter(vpa);

        vp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position){
                super.onPageSelected(position);
                cur_index = position;
            }

            @Override
            public void onPageScrollStateChanged(int state){
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void initGiftFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        gf = new GiftFragment();
        transaction.add(R.id.gift_frag, gf);
        transaction.hide(gf);
        transaction.show(gf);
        transaction.commit();
    }

    public void hideGiftFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(gf != null){
            debug_txt.setText("gf != null");
            transaction.hide(gf);
        }else{
            debug_txt.setText("gf == null");
            gf = getSupportFragmentManager().findFragmentById(R.id.gift_frag);
            transaction.hide(gf);
        }
        transaction.commit();
    }



    public void updateLikes(){
         if(cur_index == 0) vf1.setLikes();
         else if(cur_index == 1) vf2.setLikes();
         else if(cur_index == 2) vf3.setLikes();
    }


    //Fragments向Activity传参
    public void sendInt_Gift(int x) {
        if(cur_index == 0) vf1.setGifts(x);
        else if(cur_index == 1) vf2.setGifts(x);
        else if(cur_index == 2) vf3.setGifts(x);
    }

    public void sendString1(String strValue) {

    }
    public void sendInt1(int x) {

    }

    public void sendString2(String strValue) {

    }
    public void sendInt2(int x) {

    }

    public void sendString3(String strValue) {

    }
    public void sendInt3(int x) {

    }


}