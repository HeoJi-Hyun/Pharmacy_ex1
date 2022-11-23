package com.example.pharmacy_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
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

public class Pharm extends AppCompatActivity {

    String urladdress = "http://hjh1963.dothome.co.kr/pharmlist.php";
    String[] pharmName;
    ListView listView;
    RelativeLayout relativeLayout;
    BufferedInputStream is;
    String line=null;
    String result=null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pharm);

        listView=(ListView) findViewById(R.id.listview);
        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        PharmListView pharmListView= new PharmListView(this, pharmName);
        listView.setAdapter(pharmListView);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                TextView textview= (TextView)arg1.findViewById(R.id.pharmName);
                String str = (String) textview.getText();

                if (str.equals("코아약국")){
                    Intent a = new Intent(Pharm.this, Pharm1.class);
                    startActivity(a);
                }
                else if (str.equals("고황약국")){
                    Intent b = new Intent(Pharm.this, Pharm3.class);
                    startActivity(b);
                }
                if (str.equals("경희정문약국")){
                    Intent c = new Intent(Pharm.this, Pharm2.class);
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
            pharmName = new String[ja.length()];

            for(int i=0; i<=ja.length(); i++){
                jo=ja.getJSONObject(i);
                pharmName[i]=jo.getString("pharmName");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    }
//        auto = (AutoCompleteTextView) findViewById(R.id.autoPharm);


//        list = new ArrayList<String>();

        // 리스트에 검색될 데이터(단어)를 추가한다.
//        settingList();
//
//        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoPharm);
//
//        // AutoCompleteTextView 에 아답터를 연결한다.
//        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, list));
//    }

//    private void settingList() {
//        list.add("코아약국");
//        list.add("경희정문약국");
//        list.add("고황약국");
//        list.add("성심약국");
//        list.add("경희메디칼약국");
//        list.add("크로바약국");
//        list.add("경희온누리약국");

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (auto.getText().toString().equals("코아약국")){
//                    Intent intent6 = new Intent(Pharm.this, Pharm1.class);
//
//                    startActivity(intent6);
//                }
//                else if (auto.getText().toString().equals("경희정문약국")){
//                    Intent intent7 = new Intent(Pharm.this, Pharm2.class);
//
//                    startActivity(intent7);
//                }
//                else if (auto.getText().toString().equals("고황약국")){
//                    Intent intent8 = new Intent(Pharm.this,Pharm3.class);
//
//                    startActivity(intent8);
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "해당 약국이 없습니다", Toast.LENGTH_LONG).show();
//                }
//            }
//        });



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

