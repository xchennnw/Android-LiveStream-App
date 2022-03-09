package com.example.livestreamapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import java.util.*;

public class VideoFragment1 extends Fragment{

    private Activity m_activity;

    public String name ;
    public int likes;
    public int gifts;
    public String video_address;
    public ArrayList<String> comment_list;

    static TextView video_name;
    static TextView video_likes;
    static TextView video_gifts;
    RelativeLayout lay_out;

    public CallBackValue1 callBackValue;

    public VideoFragment1(){
        name = "Xun";
        likes = 0;
        gifts = 0;
    }

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment, container, false);
        video_name = view.findViewById(R.id.v_name);
        video_likes = view.findViewById(R.id.v_likes);
        video_gifts = view.findViewById(R.id.v_gifts);
        lay_out = view.findViewById(R.id.v_rela);
        // video_view = view.findViewById(R.id.video_view);
        video_name.setText("主播:"+name);
        video_likes.setText("赞："+likes);
        video_gifts.setText("礼物："+gifts);
        lay_out.setBackgroundColor(Color.parseColor("#B0C4DE"));
        return view;
    }

    public void setLikes(){
        likes++;
        video_likes.setText("赞："+likes);
    }

    public void setGifts(int x){
        gifts += x;
        video_gifts.setText("礼物："+gifts);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        m_activity = getActivity();
        callBackValue =(CallBackValue1) m_activity;
    }

    //Fragment向Activity传参接口
    public interface CallBackValue1{
        void sendString1(String strValue);
        void sendInt1(int intValue);
    }

}
