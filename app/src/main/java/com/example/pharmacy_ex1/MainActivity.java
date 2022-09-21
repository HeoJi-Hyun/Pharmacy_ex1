package com.example.pharmacy_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edittextId1, edittextPw1;
    Button btnJoin1, btnLogin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittextId1 = (EditText) findViewById(R.id.edId1);
        edittextPw1 = (EditText) findViewById(R.id.edPw1);

        btnJoin1 = (Button) findViewById(R.id.btnJoin);
        btnLogin1 = (Button) findViewById(R.id.btnLogin);

        btnJoin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Join.class);
                startActivity(intent);

            }
        });
    }
}