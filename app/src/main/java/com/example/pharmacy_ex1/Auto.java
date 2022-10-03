package com.example.pharmacy_ex1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.List;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class Auto extends Activity {
    private List<String> list;
    AutoCompleteTextView auto;
    Button btn1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto0);

        auto = (AutoCompleteTextView) findViewById(R.id.autoSearch);
        btn1 = (Button)findViewById(R.id.btnChek1);

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

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (auto.getText().toString().equals("타이레놀")){
                    Intent intent6 = new Intent(Auto.this, Prov1.class);

                    startActivity(intent6);
                }
                else if (auto.getText().toString().equals("탁센")){
                    Intent intent7 = new Intent(Auto.this, Prov2.class);

                    startActivity(intent7);
                }
                else if (auto.getText().toString().equals("광동경옥고")){
                    Intent intent8 = new Intent(Auto.this, Prov3.class);

                    startActivity(intent8);
                }
                else{
                    Toast.makeText(getApplicationContext(), "해당 제품이 없습니다", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

}
