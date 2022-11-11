package com.example.pharmacy_ex1;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Home extends Activity  implements OnMapReadyCallback{

 Button btnala, btnprov, btnchek, btnpharm, btnMy, btnmemo;
 ImageButton btncamera;
 EditText memo;
    SharedPreferences pref;          // 프리퍼런스
    SharedPreferences.Editor editor; // 에디터

    String myStr;                   // 문자 변수



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        btnala = (Button)findViewById(R.id.homeAla);
        btnprov = (Button)findViewById(R.id.homeProv);
        btnchek = (Button)findViewById(R.id.homeChek);
        btnpharm = (Button)findViewById(R.id.homePharm);
        btncamera = (ImageButton) findViewById(R.id.homeCamera);
        btnMy = (Button) findViewById(R.id.homeMy);

        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        editor = pref.edit();

        // 2. 저장해둔 값 불러오기 ("식별값", 초기값) -> 식별값과 초기값은 직접 원하는 이름과 값으로 작성.
        myStr = pref.getString("MyStr", "_");   // String 불러오기 (저장해둔 값 없으면 초기값인 _으로 불러옴)

        memo = (EditText)findViewById(R.id.edithome1);
        btnmemo = (Button)findViewById(R.id.memook);
        // 4. 앱을 새로 켜면 이전에 저장해둔 값이 표시됨
        memo.setText(myStr);

        btnmemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myStr = memo.getText().toString();
                editor.putString("MyStr", myStr);
                editor.apply(); // 저장
            }
        });

        btnala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Home.this, Alarm.class);

                startActivity(intent3);
            }
        });
        btnchek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(Home.this, Chek.class);

                startActivity(intent4);
            }
        });
        btnprov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(Home.this, Search.class);

                startActivity(intent5);
            }
        });
        btnpharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(Home.this, Pharm.class);

                startActivity(intent6);
            }
        });

        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(Home.this, Camera.class);

                startActivity(intent7);
            }
        });

        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 = new Intent(Home.this, Mypage.class);

                startActivity(intent8);
            }
        });

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location = new LatLng(37.557667,126.926546);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("홍대입구역");
        markerOptions.snippet("전철역");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,16));
    }


}
