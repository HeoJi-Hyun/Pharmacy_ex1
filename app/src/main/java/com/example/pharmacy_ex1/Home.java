package com.example.pharmacy_ex1;

import android.app.Activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends Activity  implements OnMapReadyCallback{
    private FragmentManager fragmentManager;
    private MapFragment mapFragment;

//    SettingFragment settingFragment;

//    Button alarmStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        fragmentManager = getFragmentManager();
        mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);

//
//        alarmStart = (Button) findViewById(R.id.alarm1);
//
//        alarmStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home.this, Alarm.class);
//                startActivity(intent);
//            }
//        });

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
