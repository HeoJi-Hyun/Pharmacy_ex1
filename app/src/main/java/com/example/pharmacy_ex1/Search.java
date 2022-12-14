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
    private List<String> list;
    AutoCompleteTextView auto;
    Button btn1;
    Button Home;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        listView_search=(ListView) findViewById(R.id.listview_search);
        relativeLayout_search = (RelativeLayout)findViewById(R.id.relativeLayout_search);

        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        collectData();
        Search_list search_list= new Search_list(this, name);
        listView_search.setAdapter(search_list);
        btn1 = (Button)findViewById(R.id.btnPharm2);
        Home = (Button)findViewById(R.id.Home);
        auto = (AutoCompleteTextView) findViewById(R.id.autoPharm);


        list = new ArrayList<String>();


        settingList();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoPharm);

        // AutoCompleteTextView ??? ???????????? ????????????.
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, list));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (auto.getText().toString().equals("????????????")){
                    Intent intent6 = new Intent(Search.this, Prov1.class);

                    startActivity(intent6);
                }
                else if (auto.getText().toString().equals("??????")){
                    Intent intent7 = new Intent(Search.this, Prov2.class);

                    startActivity(intent7);
                }
                else if (auto.getText().toString().equals("???????????????")){
                    Intent intent8 = new Intent(Search.this,Prov3.class);

                    startActivity(intent8);
                }
                else{
                    Toast.makeText(getApplicationContext(), "?????? ???????????? ????????????", Toast.LENGTH_LONG).show();
                }
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Search.this, Home2.class);
                startActivity(home);
            }
        });
    }
    private void settingList() {
        list.add("????????????");
        list.add("??????");
        list.add("???????????????");
        list.add("?????????????????????");
        list.add("???????????????");
        list.add("??????????????????????????????");
        list.add("?????????????????????");


        listView_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                TextView tv= (TextView)arg1.findViewById(R.id.name);
                String str = (String) tv.getText();

                if (str.equals("????????????")){
                    Intent a = new Intent(Search.this, Prov1.class);
                    startActivity(a);
                }
                else if (str.equals("??????")){
                    Intent b = new Intent(Search.this, Prov2.class);
                    startActivity(b);
                }
                if (str.equals("???????????????")){
                    Intent c = new Intent(Search.this, Prov3.class);
                    startActivity(c);
                }
                else{
                    Toast.makeText(getApplicationContext(), "????????? ???????????? ??????????????????.", Toast.LENGTH_SHORT).show();
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
