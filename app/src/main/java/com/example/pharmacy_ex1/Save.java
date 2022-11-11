package com.example.pharmacy_ex1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Save extends AppCompatActivity {

    SharedPreferences pref;          // 프리퍼런스
    SharedPreferences.Editor editor; // 에디터

    int myInt;                      // 숫자 변수
    String myStr;                   // 문자 변수

    EditText et01, et02;            // 레이아웃 변수 EditText
    Button btn01, btn02;            // 레이아웃 변수 Button

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save);

        // 1. Shared Preference 초기화
        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        editor = pref.edit();

        // 2. 저장해둔 값 불러오기 ("식별값", 초기값) -> 식별값과 초기값은 직접 원하는 이름과 값으로 작성.
        myInt = pref.getInt("MyInt", 0);        // int 불러오기 (저장해둔 값 없으면 초기값인 0으로 불러옴)
        myStr = pref.getString("MyStr", "_");   // String 불러오기 (저장해둔 값 없으면 초기값인 _으로 불러옴)


        // 3. 레이아웃 변수 초기화
        et01 = findViewById(R.id.et01); et02 = findViewById(R.id.et02);
        btn01 = findViewById(R.id.btn01); btn02 = findViewById(R.id.btn02);

        // 4. 앱을 새로 켜면 이전에 저장해둔 값이 표시됨
        et01.setText(String.valueOf(myInt)); et02.setText(myStr);


        // 5. 각 버튼 클릭시 새로운 값 저장
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myInt = Integer.parseInt(et01.getText().toString()); // int Max값 넘게 입력하면 오류 주의.
                editor.putInt("MyInt", myInt);
                editor.apply(); // 저장
            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myStr = et02.getText().toString();
                editor.putString("MyStr", myStr);
                editor.apply(); // 저장
            }
        });
    }
}
