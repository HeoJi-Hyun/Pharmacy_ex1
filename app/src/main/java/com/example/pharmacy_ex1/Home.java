package com.example.pharmacy_ex1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.maps.OnMapReadyCallback;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;

import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;





public class Home extends AppCompatActivity implements OnMapReadyCallback{



 Button btnala, btnprov, btnchek, btnpharm, btnMy, btnmemo;
 ImageButton btncamera;
 EditText memo;
    SharedPreferences pref;          // 프리퍼런스
    SharedPreferences.Editor editor; // 에디터

    String myStr;                   // 문자 변수

    private GoogleMap mMap;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        btnala = (Button) findViewById(R.id.homeAla);
        btnprov = (Button) findViewById(R.id.homeProv);
        btnchek = (Button) findViewById(R.id.homeChek);
        btnpharm = (Button) findViewById(R.id.homePharm);
        btncamera = (ImageButton) findViewById(R.id.homeScan);
        btnMy = (Button) findViewById(R.id.homeMy);

        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        editor = pref.edit();




        // 2. 저장해둔 값 불러오기 ("식별값", 초기값) -> 식별값과 초기값은 직접 원하는 이름과 값으로 작성.
        myStr = pref.getString("MyStr", "_");   // String 불러오기 (저장해둔 값 없으면 초기값인 _으로 불러옴)

        memo = (EditText) findViewById(R.id.edithome1);
        btnmemo = (Button) findViewById(R.id.memook);
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
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        //구글맵 객체 불러오무
        mMap = googleMap;

        LatLng DEFAULT_LOCATION =new LatLng(37.5888101627338, 127.06563586510103);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(DEFAULT_LOCATION);
        markerOptions.title("삼육보건대학교");
        markerOptions.snippet("현재위치");
        //약국마커생성
        DEFAULT_LOCATION =new LatLng(37.58871942031541, 127.0626749856806);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("삼육약국")
                .snippet("도로명주소 : 서울특별시 동대문구 망우로18길 26\n" +
                        "지번 주소 : 서울 동대문구 휘경동 286-230"));


        DEFAULT_LOCATION =new LatLng(37.58973095167889, 127.06235880323358);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("크로바약국")
                .snippet("도로명주소 : 서울특별시 동대문구 망우로 80\n" +
                        "지번 주소 : 서울 동대문구 휘경동 276-45"));

        DEFAULT_LOCATION =new LatLng(37.58976489254389, 127.06206727644434);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("우리들 위생약국")
                .snippet("도로명주소 : 서울특별시 동대문구 망우로 78\n" +
                        "지번 주소 : 서울 동대문구 휘경동 276-49"));

        DEFAULT_LOCATION =new LatLng(37.59048329777857, 127.06232546302651);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("영림약국")
                .snippet("도로명주소 : 서울특별시 동대문구 망우로21길 16\n" +
                        "지번 주소 : 서울 동대문구 휘경동 254"));

        DEFAULT_LOCATION =new LatLng(37.590776031785815, 127.06249271668975);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("휘경약국")
                .snippet("도로명주소 : 서울특별시 동대문구 망우로21가길 10\n" +
                        "지번 주소 : 서울 동대문구 휘경동 252"));

        DEFAULT_LOCATION =new LatLng(37.59181842457483, 127.06750111399998);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("중랑약국")
                .snippet("도로명주소 : 서울특별시 동대문구 망우로 131\n" +
                        "지번 주소 : 서울 동대문구 휘경동 112-49"));

        DEFAULT_LOCATION =new LatLng(37.591647718787996, 127.06665174881938);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("메디칼갑산약국")
                .snippet("도로명주소 : 서울특별시 동대문구 망우로 123\n" +
                        "지번 주소 : 서울 동대문구 휘경동 71-1"));

        DEFAULT_LOCATION =new LatLng(37.589625109052086, 127.06231342489892);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("메디팜사랑약국")
                .snippet("도로명주소 : 서울특별시 동대문구 망우로18길 6\n" +
                        "지번 주소 : 서울 동대문구 휘경동 276-57"));

        DEFAULT_LOCATION =new LatLng(37.59004829609441, 127.06284027728182);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("삼육정문약국")
                .snippet("도로명주소 : 서울특별시 동대문구 망우로 86\n" +
                        "지번 주소 : 서울 동대문구 휘경동 275-5"));

        DEFAULT_LOCATION =new LatLng(37.590181763106344, 127.06175908200278);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("한가람약국")
                .snippet("도로명주소 : 서울특별시 동대문구 망우로 77\n" +
                        "지번 주소 : 서울 동대문구 휘경동 269-9"));
        DEFAULT_LOCATION =new LatLng( 37.649223092838895, 127.06250482983657);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("백약국")
                .snippet("도로명주소 : 서울특별시 노원구 동일로 1350\n" +
                        "지번 주소 : 서울 노원구 상계동 749-8"));
        DEFAULT_LOCATION =new LatLng( 37.65171924699382,  127.06168535713014);
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("보룡약국")
                .snippet("도로명주소 : 서울특별시 노원구 동일로 1380\n" +
                        "지번 주소 : 서울 노원구 상계동 728-5"));
        DEFAULT_LOCATION =new LatLng(  37.654983977154124,  127.06418119112925 );
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("자인당약국")
                .snippet("도로명주소 : 서울특별시 노원구 노해로 506\n" +
                        "지번 주소 : 서울 노원구 상계동 720-6"));
        DEFAULT_LOCATION =new LatLng(  37.65489381725883,  127.06429443763088 );
        mMap.addMarker(new MarkerOptions()
                .position(DEFAULT_LOCATION)
                .title("진약국")
                .snippet("도로명주소 : 서울특별시 노원구 노해로 452\n" +
                        "지번 주소 : 서울 노원구 상계동 734-3"));


        //마커 생성 + 지도 확대(카메라이동)
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DEFAULT_LOCATION, 18));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(SAHMYOOKpharmacy));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SAHMYOOKpharmacy,18));
        btnprov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Home.this, Search.class);
                startActivity(a);
            }
        });
        btnpharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(Home.this, Pharm.class);
                startActivity(b);
            }
        });
        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Home.this, Camera.class);
                startActivity(c);
            }
        });
        btnala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(Home.this, Alarm.class);
                startActivity(c);
            }
        });
        btnchek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d = new Intent(Home.this, Chek.class);
                startActivity(d);
            }
        });
        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent e = new Intent(Home.this, Mypage.class);
                startActivity(e);
            }
        });
    }

}
