package com.example.studyshare.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyshare.R;
import com.example.studyshare.data.AppDatabase;
import com.example.studyshare.data.entity.Complaint;
import com.example.studyshare.util.SessionManager;

import java.util.List;

public class ModeratorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!SessionManager.isModerator(this)) {
            finish();
            return;
        }

        setContentView(R.layout.activity_moderator);

        RecyclerView rv = findViewById(R.id.complaintsRv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        List<Complaint> list =
                AppDatabase.getInstance(this)
                        .complaintDao()
                        .getAll();

        rv.setAdapter(new ComplaintAdapter(this, list));
    }
}
