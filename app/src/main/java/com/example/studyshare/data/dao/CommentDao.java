package com.example.studyshare.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.studyshare.data.entity.Comment;

import java.util.List;

@Dao
public interface CommentDao {

    @Insert
    void insert(Comment comment);

    @Query("SELECT * FROM Comment WHERE materialId = :materialId")
    List<Comment> getByMaterial(int materialId);

    @Query("DELETE FROM Comment WHERE id = :id")
    void delete(int id);
}
