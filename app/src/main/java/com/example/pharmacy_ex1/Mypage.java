package com.example.pharmacy_ex1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Mypage extends Activity {
    Button chek, review;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        chek = (Button) findViewById(R.id.btnMy2);
        review = (Button)findViewById(R.id.btnMy4);

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
    }
}
