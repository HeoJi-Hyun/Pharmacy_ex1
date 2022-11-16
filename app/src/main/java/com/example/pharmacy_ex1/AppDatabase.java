package com.example.pharmacy_ex1;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {My_camera.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract CameraDao cameraDao();
}
