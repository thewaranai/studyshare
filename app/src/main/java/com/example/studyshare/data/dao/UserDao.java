package com.example.studyshare.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.studyshare.data.entity.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("SELECT * FROM User WHERE login = :login AND password = :password LIMIT 1")
    User login(String login, String password);

    @Query("UPDATE User SET role = :role WHERE email = :email")
    void updateUserRole(String email, String role);

    @Query("SELECT * FROM User WHERE id = :id")
    User getById(int id);
}
