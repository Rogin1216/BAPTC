package com.example.baptc.Databases;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = ShipItem.class, exportSchema = false)
public abstract class ShipDatabase extends RoomDatabase {
    public abstract ShipDAO shipDAO();
    private static ShipDatabase instance;

    public static ShipDatabase getInstance(Context context){
        if(instance == null)
            instance = Room.databaseBuilder(context, ShipDatabase.class, "BAPTCDB1").build();
        return instance;
    }
}
