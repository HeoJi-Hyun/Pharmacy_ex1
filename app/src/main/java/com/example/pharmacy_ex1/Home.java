package com.example.pharmacy_ex1;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Home extends Activity  implements OnMapReadyCallback{

 Button btnala, btnprov, btnchek, btnpharm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        btnala = (Button)findViewById(R.id.homeAla);
        btnprov = (Button)findViewById(R.id.homeProv);
        btnchek = (Button)findViewById(R.id.homeChek);
        btnpharm = (Button)findViewById(R.id.homePharm);

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
                Intent intent5 = new Intent(Home.this, Auto.class);

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


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng location = new LatLng(37.485284,126.901451);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("구로디지털단지역");
        markerOptions.snippet("전철역");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,16));
    }


}
