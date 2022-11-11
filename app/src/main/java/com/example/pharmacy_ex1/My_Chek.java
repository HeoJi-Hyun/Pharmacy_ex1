package com.example.pharmacy_ex1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class My_Chek extends Activity {

    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10, tv11, tv12;
    String v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12;
    LinearLayout l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    Button mychek_re, mychek_ok;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_chek);



        mychek_re = (Button) findViewById(R.id.mychek_re);
        mychek_ok = (Button) findViewById(R.id.mychek_ok);
        tv1 = (TextView) findViewById(R.id.myChek1);
        tv2 = (TextView) findViewById(R.id.myChek2);
        tv3 = (TextView) findViewById(R.id.myChek3);
        tv4 = (TextView) findViewById(R.id.myChek4);
        tv5 = (TextView) findViewById(R.id.myChek5);
        tv6 = (TextView) findViewById(R.id.myChek6);
        tv7 = (TextView) findViewById(R.id.myChek7);
        tv8 = (TextView) findViewById(R.id.myChek8);
        tv9 = (TextView) findViewById(R.id.myChek9);
        tv10 = (TextView) findViewById(R.id.myChek10);
        tv11 = (TextView) findViewById(R.id.myChek11);
        tv12 = (TextView) findViewById(R.id.myChek12);

        l1 = (LinearLayout) findViewById(R.id.layout1);
        l2 = (LinearLayout) findViewById(R.id.layout2);
        l3 = (LinearLayout) findViewById(R.id.layout3);
        l4 = (LinearLayout) findViewById(R.id.layout4);
        l5 = (LinearLayout) findViewById(R.id.layout5);
        l6 = (LinearLayout) findViewById(R.id.layout6);
        l7 = (LinearLayout) findViewById(R.id.layout7);
        l8 = (LinearLayout) findViewById(R.id.layout8);
        l9 = (LinearLayout) findViewById(R.id.layout9);
        l10 = (LinearLayout) findViewById(R.id.layout10);
        l11 = (LinearLayout) findViewById(R.id.layout11);
        l12 = (LinearLayout) findViewById(R.id.layout12);

        Intent intent = getIntent();
        v1 = intent.getStringExtra("a");
        v2 = intent.getStringExtra("b");
        v3 = intent.getStringExtra("c");
        v4 = intent.getStringExtra("d");
        v5 = intent.getStringExtra("e");
        v6 = intent.getStringExtra("f");
        v7 = intent.getStringExtra("g");
        v8 = intent.getStringExtra("h");
        v9 = intent.getStringExtra("i");
        v10 = intent.getStringExtra("j");
        v11 = intent.getStringExtra("k");
        v12 = intent.getStringExtra("l");


        tv2.setText(v2);
        tv3.setText(v3);
        tv4.setText(v4);
        tv5.setText(v5);
        tv6.setText(v6);
        tv7.setText(v7);
        tv8.setText(v8);
        tv9.setText(v9);
        tv10.setText(v10);
        tv11.setText(v11);
        tv12.setText(v12);


        tv1.setText(v1);
        if (tv1.getText().toString().equals("치매")) {
            l1.setVisibility(View.VISIBLE);
        } else {
            l1.setVisibility(View.GONE);
        }

        if (tv2.getText().toString().equals("노년백내장")) {
            l2.setVisibility(View.VISIBLE);
        } else {
            l2.setVisibility(View.GONE);
        }

        if (tv3.getText().toString().equals("폐렴")) {
            l3.setVisibility(View.VISIBLE);
        } else {
            l3.setVisibility(View.GONE);
        }

        if (tv4.getText().toString().equals("뇌경색증")) {
            l4.setVisibility(View.VISIBLE);
        } else {
            l4.setVisibility(View.GONE);
        }

        if (tv5.getText().toString().equals("신장병")) {
            l5.setVisibility(View.VISIBLE);
        } else {
            l5.setVisibility(View.GONE);
        }

        if (tv6.getText().toString().equals("어지럼증")) {
            l6.setVisibility(View.VISIBLE);
        } else {
            l6.setVisibility(View.GONE);
        }

        if (tv7.getText().toString().equals("심부전")) {
            l7.setVisibility(View.VISIBLE);
        } else {
            l7.setVisibility(View.GONE);
        }

        if (tv8.getText().toString().equals("골절")) {
            l8.setVisibility(View.VISIBLE);
        } else {
            l8.setVisibility(View.GONE);
        }

        if (tv9.getText().toString().equals("척추병증")) {
            l9.setVisibility(View.VISIBLE);
        } else {
            l9.setVisibility(View.GONE);
        }

        if (tv10.getText().toString().equals("무릎관절증")) {
            l10.setVisibility(View.VISIBLE);
        } else {
            l10.setVisibility(View.GONE);
        }

        if (tv11.getText().toString().equals("당뇨병")) {
            l11.setVisibility(View.VISIBLE);
        } else {
            l11.setVisibility(View.GONE);
        }

        if (tv12.getText().toString().equals("담석증")) {
            l12.setVisibility(View.VISIBLE);
        } else {
            l12.setVisibility(View.GONE);
        }


        mychek_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(My_Chek.this, Chek.class);
                startActivity(intent);
            }
        });
        mychek_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
