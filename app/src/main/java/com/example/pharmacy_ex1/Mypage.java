package com.example.pharmacy_ex1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Mypage extends Activity {
    Button chek, review, Mypage, Home, Scan;
    TextView myname;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        chek = (Button) findViewById(R.id.btnMy2);
        review = (Button)findViewById(R.id.btnMy4);
        Scan = (Button)findViewById(R.id.btnMy3);
        Mypage = (Button)findViewById(R.id.homeMy);
        myname = (TextView)findViewById(R.id.myname);
        Home = (Button)findViewById(R.id.Home);

        chek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Mypage.this, My_Chek.class);
                startActivity(intent1);
            }
        });
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Mypage.this, Review.class);
                startActivity(intent2);
            }
        });
        Mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Mypage.this, Mypage.class);
                startActivity(b);
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Mypage.this, Home2.class);
                startActivity(c);
            }
        });
        Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(Mypage.this, My_camera.class);
                startActivity(d);
            }
        });
    }
}
