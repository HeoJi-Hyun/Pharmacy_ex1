package com.example.pharmacy_ex1;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Join extends MainActivity{

     private EditText et_id, et_pass, et_name, et_age;
     private Button btnJoin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        et_id = (EditText) findViewById(R.id.edIdJoin2);
        et_pass = (EditText) findViewById(R.id.edPw2);
        et_name = (EditText) findViewById(R.id.edName);
        et_age = (EditText) findViewById(R.id.edAge);

        btnJoin = (Button) findViewById(R.id.btnStart);
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                int userAge = Integer.parseInt(et_age.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Join.this, MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(),"회원 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(userID, userPass, userName, userAge, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Join.this);
                queue.add(registerRequest);

//                Intent intent1 = new Intent(Join.this, MainActivity.class);
//                startActivity(intent1);
//
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                intent.putExtra("id", Integer.parseInt(edittextId2.getText().toString()));
//                intent.putExtra("pass",Integer.parseInt(edittextPw2.getText().toString()));
//
//                startActivity(intent);

            }
        });
    }
}
