
package com.example.pharmacy_ex1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Chek extends Activity {

    private List<String> list;
    AutoCompleteTextView auto;
    EditText editText1;
    ToggleButton togle1, togle2, togle3, togle4, togle5, togle6, togle7, togle8, togle9, togle10, togle11, togle12;
    Button btnOk, btnChek;
    String str1, str2,str3, str4,str5, str6,str7, str8,str9, str10, str11, str12;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chek);

        auto = (AutoCompleteTextView) findViewById(R.id.autoPharm);
        btnOk = (Button) findViewById(R.id.btnPharm2);
        btnChek = (Button) findViewById(R.id.btnChek2);

        list = new ArrayList<String>();
        settingList();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoPharm);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list));
        btnOk = (Button) findViewById(R.id.btnPharm2);
        editText1 = (EditText) findViewById(R.id.autoPharm);
        togle1 = (ToggleButton) findViewById(R.id.tog1);
        togle2 = (ToggleButton) findViewById(R.id.tog2);
        togle3 = (ToggleButton) findViewById(R.id.tog3);
        togle4 = (ToggleButton) findViewById(R.id.tog4);
        togle5 = (ToggleButton) findViewById(R.id.tog5);
        togle6 = (ToggleButton) findViewById(R.id.tog6);
        togle7 = (ToggleButton) findViewById(R.id.tog7);
        togle8 = (ToggleButton) findViewById(R.id.tog8);
        togle9 = (ToggleButton) findViewById(R.id.tog9);
        togle10 = (ToggleButton) findViewById(R.id.tog10);
        togle11 = (ToggleButton) findViewById(R.id.tog11);
        togle12 = (ToggleButton) findViewById(R.id.tog12);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText1.getText().toString().equals("치매")) {
                    togle1.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("노년백내장")) {
                    togle2.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("폐렴")) {
                    togle3.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("뇌경색증")) {
                    togle4.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("신장병")) {
                    togle5.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("어지럼증")) {
                    togle6.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("심부전")) {
                    togle7.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("골절")) {
                    togle8.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("척추병증")) {
                    togle9.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("무릎관절증")) {
                    togle10.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("당뇨병")) {
                    togle11.setTextColor(Color.BLUE);
                } else if (editText1.getText().toString().equals("담석증")) {
                    togle12.setTextColor(Color.BLUE);
                } else {
                    Toast.makeText(getApplicationContext(), "해당 질병이 없습니다", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnChek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str1 = togle1.getTextOff().toString();
                str2 = togle2.getTextOff().toString();
                str3 = togle3.getTextOff().toString();
                str4 = togle4.getTextOff().toString();
                str5 = togle5.getTextOff().toString();
                str6 = togle6.getTextOff().toString();
                str7 = togle7.getTextOff().toString();
                str8 = togle8.getTextOff().toString();
                str9 = togle9.getTextOff().toString();
                str10 = togle10.getTextOff().toString();
                str11 = togle11.getTextOff().toString();
                str12 = togle12.getTextOff().toString();

                Intent intent = new Intent(getApplicationContext(), My_Chek.class);
                if (togle1.isChecked()) {
                    intent.putExtra("a", str1);
                } else {
                }
                if (togle2.isChecked()) {
                    intent.putExtra("b", str2);
                } else {
                }
                if (togle3.isChecked()) {
                    intent.putExtra("c", str3);
                } else {
                }
                if (togle4.isChecked()) {
                    intent.putExtra("d", str4);
                } else {
                }
                if (togle5.isChecked()) {
                    intent.putExtra("e", str6);
                } else {
                }
                if (togle6.isChecked()) {
                    intent.putExtra("f", str6);
                } else {
                }
                if (togle7.isChecked()) {
                    intent.putExtra("g", str7);
                } else {
                }
                if (togle8.isChecked()) {
                    intent.putExtra("h", str8);
                } else {
                }
                if (togle9.isChecked()) {
                    intent.putExtra("i", str9);
                } else {
                }
                if (togle10.isChecked()) {
                    intent.putExtra("j", str10);
                } else {
                }
                if (togle11.isChecked()) {
                    intent.putExtra("k", str11);
                } else {
                }
                if (togle12.isChecked()) {
                    intent.putExtra("l", str12);
                } else {
                }
                startActivity(intent);
            }
        });
    }
    private void settingList() {
        list.add("치매");
        list.add("노년백내장");
        list.add("폐렴");
        list.add("뇌경색증");
        list.add("신장병");
        list.add("어지럼증");
        list.add("심부전");
        list.add("골절");
        list.add("척추병증");
        list.add("무릎 관절증");
        list.add("당뇨병");
    }



}

