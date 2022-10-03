package com.example.pharmacy_ex1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Prov3 extends AppCompatActivity {
    Prov3Frag1 frag1;
    Prov3Frag2 frag2;
    Prov3Frag3 frag3;

    TabLayout tabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prov3);

        frag1 = new Prov3Frag1();
        frag2 = new Prov3Frag2();
        frag3 = new Prov3Frag3();

        getSupportFragmentManager().beginTransaction().add(R.id.container3,frag1).commit();

        tabs = findViewById(R.id.tabs3);
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
                getSupportFragmentManager().beginTransaction().replace(R.id.container3, selected).commit();
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
