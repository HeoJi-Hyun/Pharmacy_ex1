package com.example.pharmacy_ex1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MainDat.class}, version = 1, exportSchema = false)
public abstract class RoomD extends RoomDatabase
{
    private static RoomD database;

    private static String DATABASE_NAME = "database";

    public synchronized static RoomD getInstance(Context context)
    {
        if (database == null)
        {
            database = Room.databaseBuilder(context.getApplicationContext(), RoomD.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    public abstract MainDa mainDa();

}
