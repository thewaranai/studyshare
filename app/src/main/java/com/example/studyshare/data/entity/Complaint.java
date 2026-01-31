package com.example.studyshare.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Complaint {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int materialId;
    public int userId;

    public String reason;
    public boolean processed;
}
