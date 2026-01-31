package com.example.studyshare.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyshare.R;
import com.example.studyshare.data.AppDatabase;
import com.example.studyshare.data.entity.Comment;
import com.example.studyshare.data.entity.Complaint;
import com.example.studyshare.data.entity.StudyMaterial;
import com.example.studyshare.util.SessionManager;

import java.util.List;

public class MaterialDetailsActivity extends AppCompatActivity {

    StudyMaterial material;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_details);

        int id = getIntent().getIntExtra("id", -1);
        AppDatabase db = AppDatabase.getInstance(this);

        List<StudyMaterial> all = db.materialDao().getAllVisible();
        for (StudyMaterial m : all) {
            if (m.id == id) material = m;
        }

        TextView title = findViewById(R.id.titleTv);
        TextView desc = findViewById(R.id.descTv);
        RatingBar rating = findViewById(R.id.ratingBar);

        title.setText(material.title);
        desc.setText(material.description);
        rating.setRating((float) material.rating);

        rating.setOnRatingBarChangeListener((r, value, fromUser) -> {
            db.materialDao().updateRating(material.id, value);
            Toast.makeText(this, "Оценка сохранена", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.sendCommentBtn).setOnClickListener(v -> {
            EditText et = findViewById(R.id.commentEt);

            if (et.getText().toString().isEmpty()) return;

            Comment c = new Comment();
            c.materialId = material.id;
            c.userId = SessionManager.getUserId(this);
            c.text = et.getText().toString();

            db.commentDao().insert(c);
            et.setText("");

            Toast.makeText(this, "Комментарий добавлен", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.complaintBtn).setOnClickListener(v -> {
            Complaint comp = new Complaint();
            comp.materialId = material.id;
            comp.userId = SessionManager.getUserId(this);
            comp.reason = "Нарушение правил";
            comp.processed = false;

            db.complaintDao().insert(comp);

            Toast.makeText(this, "Жалоба отправлена", Toast.LENGTH_SHORT).show();
        });
    }
}
