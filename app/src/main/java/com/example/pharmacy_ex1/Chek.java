
package com.example.pharmacy_ex1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class Chek extends Activity {

    private List<String> list;
    AutoCompleteTextView auto;
    EditText editText1;
    ToggleButton togle1, togle2, togle3, togle4, togle5, togle6, togle7,togle8,togle9,togle10, togle11, togle12;
    Button btnOk;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chek);

        auto = (AutoCompleteTextView) findViewById(R.id.autoChek);
        btnOk = (Button)findViewById(R.id.btnChek1);

        list = new ArrayList<String>();
        settingList();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoChek);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list));
        btnOk = (Button)findViewById(R.id.btnChek1);
        editText1 = (EditText)findViewById(R.id.autoChek);
        togle1 = (ToggleButton)findViewById(R.id.tog1);
        togle2 = (ToggleButton)findViewById(R.id.tog2);
        togle3 = (ToggleButton)findViewById(R.id.tog3);
        togle4 = (ToggleButton)findViewById(R.id.tog4);
        togle5 = (ToggleButton)findViewById(R.id.tog5);
        togle6 = (ToggleButton)findViewById(R.id.tog6);
        togle7 = (ToggleButton)findViewById(R.id.tog7);
        togle8 = (ToggleButton)findViewById(R.id.tog8);
        togle9 = (ToggleButton)findViewById(R.id.tog9);
        togle10 = (ToggleButton)findViewById(R.id.tog10);
        togle11 = (ToggleButton)findViewById(R.id.tog11);
        togle12 = (ToggleButton)findViewById(R.id.tog12);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText1.getText().toString().equals("치매")){
                   togle1.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("노년백내장")){
                    togle2.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("폐렴")){
                    togle3.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("뇌경색증")){
                    togle4.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("신장병")){
                    togle5.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("어지럼증")){
                    togle6.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("심부전")){
                    togle7.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("골절")){
                    togle8.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("척추병증")){
                    togle9.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("무릎관절증")){
                    togle10.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("당뇨병")){
                    togle11.setTextColor(Color.BLUE);
                }
                else if (editText1.getText().toString().equals("담석증")){
                    togle12.setTextColor(Color.BLUE);
                }
                else{
                    Toast.makeText(getApplicationContext(), "해당 질병이 없습니다", Toast.LENGTH_LONG).show();                }
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
