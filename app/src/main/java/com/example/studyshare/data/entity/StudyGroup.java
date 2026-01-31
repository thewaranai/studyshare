package com.example.studyshare.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StudyGroup {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
}
