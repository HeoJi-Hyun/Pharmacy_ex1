package com.example.pharmacy_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
public class Review_Ditail extends AppCompatActivity {

    // 로그에 사용할 TAG
    final private String TAG = getClass().getSimpleName();

    // 사용할 컴포넌트 선언
    TextView title_tv, content_tv, date_tv;

    // 선택한 게시물의 번호
    String board_seq = "";

    // 유저아이디 변수
    String userid = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_ditail);

// ListActivity 에서 넘긴 변수들을 받아줌
        board_seq = getIntent().getStringExtra("board_seq");
        userid = getIntent().getStringExtra("userid");

// 컴포넌트 초기화
        title_tv = findViewById(R.id.title_tv);
        content_tv = findViewById(R.id.content_tv);
        date_tv = findViewById(R.id.date_tv);





// 해당 게시물의 데이터 불러오기
        InitData();

    }

    private void InitData(){

// 해당 게시물의 데이터를 읽어오는 함수, 파라미터로 보드 번호를 넘김
        LoadBoard loadBoard = new LoadBoard();
        loadBoard.execute(board_seq);

    }

    class LoadBoard extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.d(TAG, "onPreExecute");
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d(TAG, "onPostExecute, " + result);
            try {
// 결과값이 JSONArray 형태로 넘어오기 때문에
// JSONArray, JSONObject 를 사용해서 파싱
                JSONArray jsonArray = null;
                jsonArray = new JSONArray(result);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

// Database 의 데이터들을 변수로 저장한 후 해당 TextView 에 데이터 입력
                    String title = jsonObject.optString("title");
                    String content = jsonObject.optString("content");
                    String crt_dt = jsonObject.optString("crt_dt");

                    title_tv.setText(title);
                    content_tv.setText(content);
                    date_tv.setText(crt_dt);

                }


// 호출할 php 파일 경로
                String server_url = "http://15.164.252.136/load_board_detail.php";


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
                            .appendQueryParameter("board_seq", board_seq);
                    String query = builder.build().getEncodedQuery();

                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(query);
                    writer.flush();
                    writer.close();
                    os.close();

                    conn.connect();
                    int responseCode = conn.getResponseCode();

                    if (responseCode == HttpsURLConnection.HTTP_OK) {
                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        while ((line = br.readLine()) != null) {
                            response += line;
                        }
                    } else {
                        response = "";

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return response;
               }
        }
    }
}