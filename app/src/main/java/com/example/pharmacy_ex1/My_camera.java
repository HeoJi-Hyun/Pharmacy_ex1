package com.example.pharmacy_ex1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class My_camera {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;

    public My_camera(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return id+":"+ title+"\n";
    }
}
