package com.example.studyshare.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.studyshare.data.entity.Complaint;

import java.util.List;

@Dao
public interface ComplaintDao {

    @Insert
    void insert(Complaint complaint);

    @Query("SELECT * FROM Complaint WHERE processed = 0")
    List<Complaint> getAll();

    @Query("UPDATE Complaint SET processed = 1 WHERE id = :id")
    void markProcessed(int id);

    @Query("DELETE FROM Complaint WHERE id = :id")
    void delete(int id);
}
