package com.example.pharmacy_ex1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Review extends AppCompatActivity
{
    EditText editText;
    Button btAdd;
    RecyclerView recycler;

    List<MainDat> dataList = new ArrayList<>();
    RoomD database;
    MainAdapte adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        editText = findViewById(R.id.edit_text);
        btAdd = findViewById(R.id.bt_add);
        recycler = findViewById(R.id.recycler);

        database = RoomD.getInstance(this);

        dataList = database.mainDa().getAll();

        recycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MainAdapte(Review.this, dataList);

        recycler.setAdapter(adapter);

        btAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String Text = editText.getText().toString().trim();
                if (!Text.equals(""))
                {
                    MainDat data = new MainDat();
                    data.setText(Text);
                    database.mainDa().insert(data);

                    editText.setText("");

                    dataList.clear();
                    dataList.addAll(database.mainDa().getAll());
                    adapter.notifyDataSetChanged();
                }
            }
        });


    }
}