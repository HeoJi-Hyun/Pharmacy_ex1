package com.example.pharmacy_ex1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.InputStream;


public class Search_list extends ArrayAdapter<String> {

    private String[] name;
    private Activity context;

    Bitmap bitmap;


    public Search_list(Activity context, String[] searchName ) {
        super(context, R.layout.search_list,searchName);//pharmlist는 xml이름
        this.context=context;
        this.name=searchName;


    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View r = convertView;
        ViewHolder viewHolder=null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.search_list, null, true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);

        }
        else {
            viewHolder=(ViewHolder) r.getTag();

        }
        viewHolder.tv1.setText(name[position]);//컬럼id이름은 pharmName

        return r;

    }
    class ViewHolder{
        TextView tv1;

        ViewHolder(View v){
            tv1=(TextView) v.findViewById(R.id.name);//list레이아웃 textview id가 pharmName
        }
    }
}

