package com.example.studyshare.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyshare.R;
import com.example.studyshare.data.AppDatabase;
import com.example.studyshare.data.entity.StudyMaterial;
import com.example.studyshare.util.SessionManager;

public class UploadMaterialActivity extends AppCompatActivity {

    EditText titleEt, descEt, disciplineEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        titleEt = findViewById(R.id.titleEt);
        descEt = findViewById(R.id.descEt);
        disciplineEt = findViewById(R.id.disciplineEt);

        findViewById(R.id.uploadBtn).setOnClickListener(v -> {
            StudyMaterial m = new StudyMaterial();
            m.title = titleEt.getText().toString();
            m.description = descEt.getText().toString();
            m.discipline = disciplineEt.getText().toString();
            m.type = "TEXT";
            m.authorId = SessionManager.getUserId(this);
            m.rating = 0;
            m.blocked = false;

            AppDatabase.getInstance(this)
                    .materialDao()
                    .insert(m);

            Toast.makeText(this, "Материал добавлен", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
