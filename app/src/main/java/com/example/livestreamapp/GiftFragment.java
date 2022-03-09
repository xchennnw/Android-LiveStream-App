package com.example.livestreamapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class GiftFragment extends Fragment {

    private Activity m_activity;
    public GiftCallBackValue callBackValue;

    public GiftFragment(){

    }

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gift_fragment, container, false);

        Button btn1 = view.findViewById(R.id.btn1);
        Button btn2 = view.findViewById(R.id.btn2);
        Button btn3 = view.findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                callBackValue.sendInt_Gift(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                callBackValue.sendInt_Gift(10);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                callBackValue.hideGiftFragment();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        m_activity = getActivity();
        callBackValue =(GiftCallBackValue) m_activity;
    }

    //Fragment向Activity传参接口
    public interface GiftCallBackValue{
        void sendInt_Gift(int intValue);
        void hideGiftFragment();
    }
}
