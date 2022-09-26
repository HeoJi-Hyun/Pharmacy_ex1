package com.example.pharmacy_ex1;

import android.app.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class Home extends Activity  implements OnMapReadyCallback{

private Frag1 frag1;
private Frag2 frag2;
private Frag3 frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();

//        FragmentManager manager = getSupportFragmentManager();
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag1).commit();
//        BottomNavigationView bottom_menu = findViewById(R.id.bottom_menu);
//        bottom_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.bottom_search:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag1).commit();
//                        return true;
//                    case R.id.bottom_camera:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag2).commit();
//                        return true;
//                    case R.id.bottom_review:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag3).commit();
//                        return true;
//                }
//                return false;
//            }
//        });
//    }
//    private FragmentManager getSupportFragmentManager() {
//        return null;
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
