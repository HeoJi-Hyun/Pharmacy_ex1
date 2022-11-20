package com.example.pharmacy_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    // 로그에 사용할 TAG 변수 선언
    final private String TAG = getClass().getSimpleName();

    private EditText et_id, et_pass;
    Button btnJoin1, btnLogin1;
//    Integer v1, v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = (EditText) findViewById(R.id.edId1);
        et_pass = (EditText) findViewById(R.id.edPw1);
        btnLogin1 = (Button) findViewById(R.id.btnLogin);
        btnJoin1 = (Button) findViewById(R.id.btnJoin);

        btnJoin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Join.class);
                startActivity(intent);
            }
        });
        btnLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그인 함수
                LoginTask loginTask = new LoginTask();
                loginTask.execute(et_id.getText().toString(), et_pass.getText().toString());
            }
        });

    }

    class LoginTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.d(TAG, "onPreExecute");
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d(TAG, "onPostExecute, " + result);

            if(result.equals("success")){
// 결과값이 success 이면
// 토스트 메시지를 뿌리고
// userid 값을 가지고 ReviewAll 로 이동
                Toast.makeText(MainActivity.this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ReviewAll.class);
                intent.putExtra("userid", et_id.getText().toString());
                startActivity(intent);
            }else
            {
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String userid = params[0];
            String passwd = params[1];

            String server_url = "http://15.164.252.136/login.php";


            URL url;
            String response = "";
            try {
                url = new URL(server_url);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("userid", userid)
                        .appendQueryParameter("passwd", passwd);
                String query = builder.build().getEncodedQuery();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();

                conn.connect();
                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    String line;
                    BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line=br.readLine()) != null) {
                        response+=line;
                    }
                }
                else {
                    response="";

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        }
    }

}
////                String userID = et_id.getText().toString();
////                String userPass = et_pass.getText().toString();
//
//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            boolean success = jsonObject.getBoolean("success");
//                            if(success){
//                                String userID = jsonObject.getString("userID");
//                                String userPass = jsonObject.getString("userPassword");
//
//                                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(MainActivity.this, Home.class);
//                                intent.putExtra(userID, userID);
//                                intent.putExtra(userPass, userPass);
//                                startActivity(intent);
//                            }else{
//                                Toast.makeText(getApplicationContext(),"로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
//                                return;
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
//                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//                queue.add(loginRequest);
//            }
//        });

//        Intent intent = getIntent();
//        v1 = intent.getIntExtra("id", 0);
//        v2 = intent.getIntExtra("pass", 0);
//
//
//        btnLogin1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (edittextId1.getText().toString().equals(v1.toString()) && edittextPw1.getText().toString().equals(v2.toString())) {
//
//                    Intent intent = new Intent(MainActivity.this, Home.class);
//
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
