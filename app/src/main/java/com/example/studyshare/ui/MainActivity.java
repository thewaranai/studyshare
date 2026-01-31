package com.example.studyshare.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyshare.R;
import com.example.studyshare.data.AppDatabase;
import com.example.studyshare.data.entity.StudyMaterial;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.materialsRv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.uploadBtn)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, UploadMaterialActivity.class)));

        findViewById(R.id.moderatorBtn)
                .setOnClickListener(v ->
                        startActivity(new Intent(this, ModeratorActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        load();
    }

    private void load() {
        List<StudyMaterial> list =
                AppDatabase.getInstance(this)
                        .materialDao()
                        .getAllVisible();

        rv.setAdapter(new MaterialAdapter(this, list));
    }
}
