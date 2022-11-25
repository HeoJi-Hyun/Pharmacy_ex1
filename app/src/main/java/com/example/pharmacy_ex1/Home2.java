package com.example.pharmacy_ex1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Home2 extends AppCompatActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
       //구글맵 객체 불러옴
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



        //마커 생성 + 지도 확대(카메라이동)
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DEFAULT_LOCATION, 18));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(SAHMYOOKpharmacy));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SAHMYOOKpharmacy,18));
    }

}

