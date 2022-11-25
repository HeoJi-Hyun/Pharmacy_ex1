package com.example.pharmacy_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {

    String urladdress = "http://hjh1963.dothome.co.kr/searchlist.php";
    String[] name;
    ListView listView_search;
    RelativeLayout relativeLayout_search;
    BufferedInputStream is;
    String line=null;
    String result=null;
    AutoCompleteTextView auto;
    Button btn1,btnhome;
    private List<String> list;

    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        listView_search=(ListView) findViewById(R.id.listview_search);
        relativeLayout_search = (RelativeLayout)findViewById(R.id.relativeLayout_search);
        btn1 = (Button)findViewById(R.id.btnProv);//검색버튼
        btnhome = (Button)findViewById(R.id.btn_home);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        Search_list search_list= new Search_list(this, name);
        listView_search.setAdapter(search_list);

        auto = (AutoCompleteTextView) findViewById(R.id.autoProv);


        list = new ArrayList<String>();


        settingList();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoProv);

        // AutoCompleteTextView 에 아답터를 연결한다.
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, list));
    }

    private void settingList() {
        list.add("타이레놀");
        list.add("탁센");
        list.add("광동경옥고");
        list.add("판콜에스내복약");
        list.add("판피린큐액");
        list.add("아로나민골드프리미엄");
        list.add("케토톱플라스타");
        list.add("벤포벨S에스정");
        list.add("까스활명수");

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Search.this, Home2.class);

                startActivity(a);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (auto.getText().toString().equals("타이레놀")){
                    Intent intent6 = new Intent(Search.this, Prov1.class);

                    startActivity(intent6);
                }
                else if (auto.getText().toString().equals("탁센")){
                    Intent intent7 = new Intent(Search.this, Prov2.class);

                    startActivity(intent7);
                }
                else if (auto.getText().toString().equals("광동경옥고")){
                    Intent intent8 = new Intent(Search.this,Prov3.class);

                    startActivity(intent8);
                }
                else{
                    Toast.makeText(getApplicationContext(), "해당 약이 없습니다", Toast.LENGTH_LONG).show();
                }
            }
        });


        listView_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                TextView tv= (TextView)arg1.findViewById(R.id.name);
                String str = (String) tv.getText();

                if (str.equals("타이레놀")){
                    Intent a = new Intent(Search.this, Prov1.class);
                    startActivity(a);
                }
                else if (str.equals("탁센")){
                    Intent b = new Intent(Search.this, Prov2.class);
                    startActivity(b);
                }
                if (str.equals("광동경옥고")){
                    Intent c = new Intent(Search.this, Prov3.class);
                    startActivity(c);
                }
                else{

                }
            }
        });
    }
    private void collectData()
    {
        try{

            URL url = new URL(urladdress);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            is=new BufferedInputStream(con.getInputStream());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine())!= null){
                sb.append(line+"\n");
            }
            is.close();
            result=sb.toString();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        try{
            JSONArray ja = new JSONArray(result);
            JSONObject jo = null;
            name = new String[ja.length()];

            for(int i=0; i<=ja.length(); i++){
                jo=ja.getJSONObject(i);
                name[i]=jo.getString("name");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}




//    }

//        tv1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                    Intent intent1 = new Intent(Pharm.this, Pharm1.class);
//
//                    startActivity(intent1);
//            }
//        });
//        tv2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                    Intent intent2 = new Intent(Pharm.this,Pharm2.class);
//                    startActivity(intent2);
//            }
//        });
//        tv3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                    Intent intent3 = new Intent(Pharm.this, Pharm3.class);
//
//                    startActivity(intent3);
//            }
//        });


//    @Override
//    public void onMapReady(@NonNull GoogleMap googleMap) {
//        LatLng location = new LatLng(37.485284,126.901451);
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.title("구로디지털단지역");
//        markerOptions.snippet("전철역");
//        markerOptions.position(location);
//        googleMap.addMarker(markerOptions);
//
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,10));
//
//    }

