package com.example.pharmacy_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edittextId1, edittextPw1;
    Button btnJoin1, btnLogin1, btn8, btn9, btn10;
    Integer v1, v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittextId1 = (EditText) findViewById(R.id.edId1);
        edittextPw1 = (EditText) findViewById(R.id.edPw1);
        btnLogin1 = (Button) findViewById(R.id.btnLogin);
        btn8 = (Button) findViewById(R.id.btnAla);
        btn9 = (Button) findViewById(R.id.btnMain);
        btnJoin1 = (Button) findViewById(R.id.btnJoin);
        btn10 = (Button) findViewById(R.id.btnAuto);


        btnJoin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Join.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        v1 = intent.getIntExtra("id", 0);
        v2 = intent.getIntExtra("pass", 0);


        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edittextId1.getText().toString().equals(v1.toString()) && edittextPw1.getText().toString().equals(v2.toString())) {

                    Intent intent1 = new Intent(MainActivity.this, Home.class);

                    startActivity(intent1);
                } else {
                    Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 = new Intent(MainActivity.this, Alarm.class);
                startActivity(intent8);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(MainActivity.this, Home.class);
                startActivity(intent9);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent10 = new Intent(MainActivity.this, Auto.class);
                startActivity(intent10);

            }
        });
    }
}