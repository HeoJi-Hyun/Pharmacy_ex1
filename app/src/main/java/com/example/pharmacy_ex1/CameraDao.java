package com.example.pharmacy_ex1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CameraDao {
    @Query("SELECT * FROM My_camera")
    List<My_camera>getAll();

    @Insert
    void insert(My_camera ok);

    @Update
    void update(My_camera ok);

    @Delete
    void delete(My_camera ok);

}
