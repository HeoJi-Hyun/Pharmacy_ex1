package com.example.pharmacy_ex1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.room.Room;

public class Camera_ok extends Activity {
    String v1, text;
    EditText tv;
    Button btnok, btnsave, btndelete;
    TextView tvmed, list;
    private CameraDao CD;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_ok);
        tv = (EditText) findViewById(R.id.tv_scan);
        btnok = (Button) findViewById(R.id.btn_ok);
        btnsave = (Button) findViewById(R.id.btn_save);
        tvmed = (TextView)findViewById(R.id.tvmed);
        list = (TextView)findViewById(R.id.list);
        btndelete = (Button)findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        v1 = intent.getStringExtra("a");
        tv.setText(v1);

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class,"camera-db")
                .allowMainThreadQueries()
                .build();
        list.setText(db.cameraDao().getAll().toString());

                btnok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        text = tv.getText().toString();

                if(text != null)
                    tvmed.setText(text);
                tv.setText("");
            }
        });
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.cameraDao().insert(new My_camera(tvmed.getText().toString()));
                list.setText(db.cameraDao().getAll().toString());
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
//    @Override
//    protected void onPause() { // Activity가 보이지 않을때 값을 저장한다.
//        super.onPause();
//        saveState();
//    }
//
//    @Override
//    protected void onStart() {  // Activity가 보이기 시작할때 값을 저장한다.
//        super.onStart();
//        restoreState();
//        if(text != null)
//            tvmed.setText(text);
//
//    }
//
//    protected void saveState(){ // 데이터를 저장한다.
//        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString("text", text);
//
//        editor.commit();
//
//
//    }
//    protected void restoreState(){  // 데이터를 복구한다.
//        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
//        if((pref!=null) && (pref.contains("text"))){
//            text = pref.getString("text", "");
//        }
//
//    }
//    protected void clearPref(){  // sharedpreference에 쓰여진 데이터 지우기
//        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.clear();
//        text = null;
//        editor.commit();
//    }

}
