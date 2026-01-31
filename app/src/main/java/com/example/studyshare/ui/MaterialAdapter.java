package com.example.studyshare.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyshare.R;
import com.example.studyshare.data.entity.StudyMaterial;

import java.util.List;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.Holder> {

    Context context;
    List<StudyMaterial> list;

    public MaterialAdapter(Context context, List<StudyMaterial> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_material, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder h, int i) {
        StudyMaterial m = list.get(i);

        h.title.setText(m.title);
        h.discipline.setText(m.discipline);
        h.ratingBar.setRating((float) m.rating);

        h.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MaterialDetailsActivity.class);
            intent.putExtra("id", m.id);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView title, discipline;
        RatingBar ratingBar;

        Holder(@NonNull View v) {
            super(v);
            title = v.findViewById(R.id.titleTv);
            discipline = v.findViewById(R.id.disciplineTv);
            ratingBar = v.findViewById(R.id.ratingBar);
        }
    }
}
