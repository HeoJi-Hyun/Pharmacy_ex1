package com.example.pharmacy_ex1;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;


public class Auto extends Activity {
    private List<String> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto0);

        // 리스트를 생성한다.
        list = new ArrayList<String>();

        // 리스트에 검색될 데이터(단어)를 추가한다.
        settingList();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        // AutoCompleteTextView 에 아답터를 연결한다.
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,  list ));
    }
    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){
        list.add("타이레놀");
        list.add("까스활명수");
        list.add("탁센");
    }

}
