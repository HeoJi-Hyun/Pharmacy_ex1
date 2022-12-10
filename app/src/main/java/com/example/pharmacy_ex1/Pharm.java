package com.example.pharmacy_ex1;

import static android.R.layout.simple_dropdown_item_1line;

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

public class Pharm extends AppCompatActivity {

    String urladdress = "http://hjh1963.dothome.co.kr/pharmlist.php";
    String[] pharmName;
    ListView listView;
    RelativeLayout relativeLayout;
    BufferedInputStream is;
    String line=null;
    String result=null;
    private List<String> list;
    AutoCompleteTextView auto;
    Button btn1;
    Button Home;
    @SuppressLint({"MissingInflatedId", "CutPasteId"})
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
        btn1 = (Button)findViewById(R.id.btnPharm2);
        Home = (Button)findViewById(R.id.Home);

        auto = (AutoCompleteTextView) findViewById(R.id.autoPharm);


        list = new ArrayList<String>();


        settingList();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoPharm);

        // AutoCompleteTextView 에 아답터를 연결한다.
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,
                simple_dropdown_item_1line, list));

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
                else if (auto.getText().toString().equals("한가람약국")){
                    Intent intent9 = new Intent(Pharm.this,Pharm4.class);

                    startActivity(intent9);
                }
                else if (auto.getText().toString().equals("우리들위생약국")){
                    Intent intent10 = new Intent(Pharm.this,Pharm5.class);

                    startActivity(intent10);
                }
                else if (auto.getText().toString().equals("크로바약국")){
                    Intent intent11 = new Intent(Pharm.this,Pharm6.class);

                    startActivity(intent11);
                }
                else if (auto.getText().toString().equals("메디팜사랑약국")){
                    Intent intent12 = new Intent(Pharm.this,Pharm7.class);

                    startActivity(intent12);
                }
                else if (auto.getText().toString().equals("삼육정문약국")){
                    Intent intent13 = new Intent(Pharm.this,Pharm8.class);

                    startActivity(intent13);
                }
                else if (auto.getText().toString().equals("영림약국")){
                    Intent intent14 = new Intent(Pharm.this,Pharm9.class);

                    startActivity(intent14);
                }
                else{
                    Toast.makeText(getApplicationContext(), "해당 약국이 없습니다", Toast.LENGTH_LONG).show();
                }
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Pharm.this, Home2.class);
                startActivity(home);
            }
        });
    }


    private void settingList() {
        list.add("코아약국");
        list.add("경희정문약국");
        list.add("고황약국");
        list.add("한가람약국");
        list.add("우리들위생약국");
        list.add("크로바약국");
        list.add("메디팜사랑약국");
        list.add("삼육정문약국");
        list.add("영림약국");

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
                else if (str.equals("경희정문약국")){
                    Intent c = new Intent(Pharm.this, Pharm2.class);
                    startActivity(c);
                }
                else if (str.equals("한가람약국")){
                    Intent d = new Intent(Pharm.this,Pharm4.class);

                    startActivity(d);
                }
                else if (str.equals("우리들위생약국")){
                    Intent e = new Intent(Pharm.this,Pharm5.class);

                    startActivity(e);
                }
                else if (str.equals("크로바약국")){
                    Intent f = new Intent(Pharm.this,Pharm6.class);

                    startActivity(f);
                }
                else if (str.equals("메디팜사랑약국")){
                    Intent g = new Intent(Pharm.this,Pharm7.class);

                    startActivity(g);
                }
                else if (str.equals("삼육정문약국")){
                    Intent h = new Intent(Pharm.this,Pharm8.class);

                    startActivity(h);
                }
                else if (str.equals("영림약국")){
                    Intent i = new Intent(Pharm.this,Pharm9.class);

                    startActivity(i);
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

