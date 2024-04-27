package com.example.todolistapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoTaskTabel {
    @Query("SELECT * FROM Task")
    LiveData<List<TaskEntity>> getAllTask();

    @Insert
    void insertTask(TaskEntity taskTabel);


    @Delete
    void deleteTask(TaskEntity taskTabel);
}
