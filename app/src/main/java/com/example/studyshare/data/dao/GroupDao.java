package com.example.studyshare.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.studyshare.data.entity.StudyGroup;

import java.util.List;

@Dao
public interface GroupDao {

    @Insert
    void insert(StudyGroup group);

    @Query("SELECT * FROM StudyGroup")
    List<StudyGroup> getAll();

    @Query("DELETE FROM StudyGroup WHERE id = :id")
    void delete(int id);
}
