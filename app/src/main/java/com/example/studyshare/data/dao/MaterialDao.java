package com.example.studyshare.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.studyshare.data.entity.StudyMaterial;

import java.util.List;

@Dao
public interface MaterialDao {

    @Insert
    void insert(StudyMaterial material);

    @Query("SELECT * FROM StudyMaterial WHERE blocked = 0")
    List<StudyMaterial> getAllVisible();

    @Query("UPDATE StudyMaterial SET rating = :rating WHERE id = :id")
    void updateRating(int id, double rating);

    @Query("UPDATE StudyMaterial SET blocked = 1 WHERE id = :id")
    void blockMaterial(int id);
}
