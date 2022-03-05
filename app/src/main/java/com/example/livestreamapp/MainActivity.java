package com.example.livestreamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        TextView txt1 = findViewById(R.id.txt1);

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                 txt1.setText("展示、写评论");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txt1.setText("点赞动画");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                txt1.setText("送礼物");
            }
        });
    }
}