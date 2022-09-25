package com.example.pharmacy_ex1;

import android.app.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class Home extends Activity  implements OnMapReadyCallback{

    Fragment cameraFragment;
    Fragment searchFragment;
    Fragment reviewFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);



       getFragmentManager().beginTransaction().replace(R.id.containers,cameraFragment).commit();

       NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
       navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               switch (item.getItemId()){
                   case R.id.bottom_camera:
                       getFragmentManager().beginTransaction().replace(R.id.containers, cameraFragment).commit();
                       return true;
                   case R.id.bottom_search:
                       getFragmentManager().beginTransaction().replace(R.id.containers, searchFragment).commit();
                       return true;
                   case R.id.bottom_review:
                       getFragmentManager().beginTransaction().replace(R.id.containers, reviewFragment).commit();
                       return true;
               }
               return false;
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
