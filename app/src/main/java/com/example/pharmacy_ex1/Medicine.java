package com.example.pharmacy_ex1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;


public class Medicine extends Activity {
    Button btn1, btn2, btn3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine);

        btn1 = (Button) findViewById(R.id.btnMedi1);
        btn2 = (Button) findViewById(R.id.btnMedi2);
        btn3 = (Button) findViewById(R.id.btnMedi13);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(Medicine.this, Prov1.class);

                startActivity(intent6);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(Medicine.this, Prov2.class);

                startActivity(intent7);
            }
        });


    }
}
