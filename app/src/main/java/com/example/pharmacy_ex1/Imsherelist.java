package com.example.pharmacy_ex1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class Imsherelist extends AppCompatActivity {

    CheckedTextView tv1, tv2, tv3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imsherelist);



        tv1 = (CheckedTextView) findViewById(R.id.autoText1);
        tv2 = (CheckedTextView) findViewById(R.id.autoText2);
        tv3 = (CheckedTextView) findViewById(R.id.autoText3);


        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(Imsherelist.this, ReviewAll.class);

                startActivity(intent6);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(Imsherelist.this, ReviewTac.class);

                startActivity(intent7);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 = new Intent(Imsherelist.this, ReviewOko.class);

                startActivity(intent8);
            }
        });
    }
}