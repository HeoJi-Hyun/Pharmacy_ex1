package com.example.pharmacy_ex1;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Join extends MainActivity{

    EditText edittextId2, edittextPw2;
    Button btnJoin2;
    View dialogView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        edittextId2 = (EditText) findViewById(R.id.edId2);
        edittextPw2 = (EditText) findViewById(R.id.edPw2);

        btnJoin2 = (Button) findViewById(R.id.btnStart);

        btnJoin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(Join.this, R.layout.joindialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(Join.this);
                dlg.setView(dialogView);
            }
        });




    }
}
