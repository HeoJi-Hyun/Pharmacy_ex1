package com.example.pharmacy_ex1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDa
{
    @Insert(onConflict = REPLACE)
    void insert(MainDat mainDat);

    @Delete
    void delete(MainDat mainDat);

    @Delete
    void reset(List<MainDat> mainDat);

    @Query("UPDATE table_name SET text = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    @Query("SELECT * FROM table_name")
    List<MainDat> getAll();
}