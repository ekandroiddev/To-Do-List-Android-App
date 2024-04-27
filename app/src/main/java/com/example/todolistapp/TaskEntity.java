package com.example.todolistapp;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Task")
public class TaskEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String taskName;
    private String taskDate;

    public TaskEntity(int id, String taskName, String taskDate) {
        this.id = id;
        this.taskName = taskName;
        this.taskDate = taskDate;
    }
    @Ignore
    public TaskEntity(String taskName, String taskDate) {
        this.taskName = taskName;
        this.taskDate = taskDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }
}
