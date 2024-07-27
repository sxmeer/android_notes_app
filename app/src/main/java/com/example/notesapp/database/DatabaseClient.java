package com.example.notesapp.database;

import android.content.Context;
import androidx.room.Room;

public class DatabaseClient {
    private AppDatabase appDatabase;

    private static DatabaseClient databaseClient;

    private Context context;

    DatabaseClient(Context context){
        this.context = context;
        appDatabase = Room.databaseBuilder(this.context,AppDatabase.class,"Notes").build();
    }

    public static synchronized DatabaseClient getDatabaseClient(Context context){
        if(databaseClient==null){
            databaseClient = new DatabaseClient(context);
        }
        return databaseClient;
    }
    public AppDatabase getAppDatabase(){
        return appDatabase;
    }
}
