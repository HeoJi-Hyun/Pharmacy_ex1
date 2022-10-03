package com.example.pharmacy_ex1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.pharmacy_ex1.Prov1Frag1;
import com.example.pharmacy_ex1.Prov1Frag2;
import com.example.pharmacy_ex1.Prov1Frag3;
import com.example.pharmacy_ex1.Prov2Frag1;
import com.example.pharmacy_ex1.Prov2Frag2;
import com.example.pharmacy_ex1.Prov2Frag3;
import com.example.pharmacy_ex1.R;
import com.google.android.material.tabs.TabLayout;

public class Prov2 extends AppCompatActivity {
    Prov2Frag1 frag21;
    Prov2Frag2 frag22;
    Prov2Frag3 frag23;

    TabLayout tabs;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.prov2);

        frag21 = new Prov2Frag1();
        frag22 = new Prov2Frag2();
        frag23 = new Prov2Frag3();

        getSupportFragmentManager().beginTransaction().add(R.id.container2,frag21).commit();
        tabs = findViewById(R.id.tabs2);
        tabs.addTab(tabs.newTab().setText("성분/효능"));
        tabs.addTab(tabs.newTab().setText("용법"));
        tabs.addTab(tabs.newTab().setText("주의사항"));
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0)
                    selected = frag21;
                else if(position == 1)
                    selected = frag22;
                else if(position == 2)
                    selected = frag23;
                getSupportFragmentManager().beginTransaction().replace(R.id.container2, selected).commit();
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
