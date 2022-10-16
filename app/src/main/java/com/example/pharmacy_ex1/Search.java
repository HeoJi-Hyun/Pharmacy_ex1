package com.example.pharmacy_ex1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.List;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Search extends Activity {
    private List<String> list;
    AutoCompleteTextView auto;
    Button btn1;
    CheckedTextView tv1, tv2, tv3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        auto = (AutoCompleteTextView) findViewById(R.id.autoSearch);
        btn1 = (Button)findViewById(R.id.btnAuto1);
        tv1 = (CheckedTextView)findViewById(R.id.autoText1);
        tv2 = (CheckedTextView)findViewById(R.id.autoText2);
        tv3 = (CheckedTextView)findViewById(R.id.autoText3);
        // 리스트를 생성한다.
        list = new ArrayList<String>();

        // 리스트에 검색될 데이터(단어)를 추가한다.
        settingList();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoSearch);

        // AutoCompleteTextView 에 아답터를 연결한다.
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,  list ));
    }
    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){
        list.add("타이레놀");
        list.add("탁센");
        list.add("광동경옥고");
        list.add("까스활명수");
        list.add("판콜에스");
        list.add("판피린큐액");
        list.add("벤포벨S에스정");
        list.add("비맥스메타비 ");
        list.add("케토톱플라스타");
        list.add("아로나민골드프리미엄");



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (auto.getText().toString().equals("타이레놀")){
                    Intent intent6 = new Intent(Search.this, Prov1.class);

                    startActivity(intent6);
                }
                else if (auto.getText().toString().equals("탁센")){
                    Intent intent7 = new Intent(Search.this, Prov2.class);

                    startActivity(intent7);
                }
                else if (auto.getText().toString().equals("광동경옥고")){
                    Intent intent8 = new Intent(Search.this, Prov3.class);

                    startActivity(intent8);
                }
                else{
                    Toast.makeText(getApplicationContext(), "해당 제품이 없습니다", Toast.LENGTH_LONG).show();
                }
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(Search.this, Prov1.class);

                startActivity(intent6);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(Search.this, Prov2.class);

                startActivity(intent7);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 = new Intent(Search.this, Prov3.class);

                startActivity(intent8);
            }
        });


    }

}
