package com.example.studyshare.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.studyshare.data.dao.CommentDao;
import com.example.studyshare.data.dao.ComplaintDao;
import com.example.studyshare.data.dao.GroupDao;
import com.example.studyshare.data.dao.MaterialDao;
import com.example.studyshare.data.dao.UserDao;
import com.example.studyshare.data.entity.Comment;
import com.example.studyshare.data.entity.Complaint;
import com.example.studyshare.data.entity.StudyGroup;
import com.example.studyshare.data.entity.StudyMaterial;
import com.example.studyshare.data.entity.User;

@Database(
        entities = {
                User.class,
                StudyGroup.class,
                StudyMaterial.class,
                Comment.class,
                Complaint.class
        },
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UserDao userDao();
    public abstract GroupDao groupDao();
    public abstract MaterialDao materialDao();
    public abstract CommentDao commentDao();
    public abstract ComplaintDao complaintDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "studyshare.db"
            ).allowMainThreadQueries().build();
        }
        return instance;
    }
}
