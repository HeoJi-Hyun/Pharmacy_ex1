package com.example.pharmacy_ex1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class Pharm extends Activity  implements OnMapReadyCallback {
    private List<String> list;
    AutoCompleteTextView auto;
    Button btn1;
    CheckedTextView tv1, tv2, tv3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pharm);
        auto = (AutoCompleteTextView) findViewById(R.id.autoPharm);
        btn1 = (Button)findViewById(R.id.btnPharm1);
        tv1 = (CheckedTextView)findViewById(R.id.tvPharm1);
        tv2 = (CheckedTextView)findViewById(R.id.tvPharm2);
        tv3 = (CheckedTextView)findViewById(R.id.tvPharm3);

        list = new ArrayList<String>();

        // 리스트에 검색될 데이터(단어)를 추가한다.
        settingList();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoPharm);

        // AutoCompleteTextView 에 아답터를 연결한다.
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,  list ));
    }

    private void settingList() {
        list.add("코아약국");
        list.add("경희정문약국");
        list.add("고황약국");
        list.add("성심약국");
        list.add("경희메디칼약국");
        list.add("크로바약국");
        list.add("경희온누리약국");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (auto.getText().toString().equals("코아약국")){
                    Intent intent6 = new Intent(Pharm.this, Pharm1.class);

                    startActivity(intent6);
                }
                else if (auto.getText().toString().equals("경희정문약국")){
                    Intent intent7 = new Intent(Pharm.this, Pharm2.class);

                    startActivity(intent7);
                }
                else if (auto.getText().toString().equals("고황약국")){
                    Intent intent8 = new Intent(Pharm.this,Pharm3.class);

                    startActivity(intent8);
                }
                else{
                    Toast.makeText(getApplicationContext(), "해당 약국이 없습니다", Toast.LENGTH_LONG).show();
                }
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent1 = new Intent(Pharm.this, Pharm1.class);

                    startActivity(intent1);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent2 = new Intent(Pharm.this,Pharm2.class);
                    startActivity(intent2);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent3 = new Intent(Pharm.this, Pharm3.class);

                    startActivity(intent3);
            }
        });
}

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location = new LatLng(37.485284,126.901451);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("구로디지털단지역");
        markerOptions.snippet("전철역");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,10));

    }
}
