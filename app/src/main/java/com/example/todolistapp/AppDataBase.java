package com.example.todolistapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TaskEntity.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static final String DB_NAME="app_Database";
    private static AppDataBase appDataBaseInstance;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService executorService =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized AppDataBase getInstance(Context context){
        if (appDataBaseInstance == null){
            appDataBaseInstance= Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDataBaseInstance;
    }

    public abstract DaoTaskTabel daoTaskTabel();
}
