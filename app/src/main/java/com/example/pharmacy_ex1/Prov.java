package com.example.pharmacy_ex1;

import static com.example.pharmacy_ex1.R.id.*;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;

public class Prov extends AppCompatActivity {


    Frag1 frag1;
    Frag2 frag2;
    Frag3 frag3;

    TabLayout tabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prov);

        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();

        getSupportFragmentManager().beginTransaction().add(R.id.container, frag1).commit();

        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("성분/효능"));
        tabs.addTab(tabs.newTab().setText("용법"));
        tabs.addTab(tabs.newTab().setText("주의사항"));
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0)
                    selected = frag1;
                else if(position == 1)
                    selected = frag2;
                else if(position == 2)
                    selected = frag3;
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
