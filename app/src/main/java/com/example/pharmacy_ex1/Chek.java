
package com.example.pharmacy_ex1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Chek extends Activity {

    EditText editText1;
    ToggleButton togle1, togle2, togle3;
    Button btnOk;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chek);


        btnOk = (Button)findViewById(R.id.ChekOk);
        editText1 = (EditText)findViewById(R.id.edit1);
        togle1 = (ToggleButton)findViewById(R.id.tog1);
        togle2 = (ToggleButton)findViewById(R.id.tog2);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText1.getText() == togle1.getTextOff())
                    togle1.setTextColor(Color.BLUE);
                else if(editText1.getText() == togle1.getTextOn())
                    togle1.setTextColor(Color.BLUE);
                else if(editText1.getText() == togle1.getText())
                    togle1.setTextColor(Color.BLUE);
                else {
                    togle1.setTextColor(Color.RED);
                }
            }
        });

    }

}
