package com.example.studyshare.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class StudyMaterial {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String description;
    public String discipline;
    public String type;

    public int authorId;

    public double rating;
    public boolean blocked;
}
