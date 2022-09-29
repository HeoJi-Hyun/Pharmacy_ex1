package com.example.pharmacy_ex1;

import static com.example.pharmacy_ex1.R.id.*;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class Prov extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prov);


    }
    private FragmentManager getSupportFragmentManager(){
        return null;
    }
}
