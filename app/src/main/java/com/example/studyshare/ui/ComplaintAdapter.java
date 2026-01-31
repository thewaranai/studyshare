package com.example.studyshare.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyshare.data.AppDatabase;
import com.example.studyshare.data.entity.Complaint;

import java.util.List;

public class ComplaintAdapter extends RecyclerView.Adapter<ComplaintAdapter.Holder> {

    Context ctx;
    List<Complaint> list;

    public ComplaintAdapter(Context ctx, List<Complaint> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView tv = new TextView(ctx);
        tv.setPadding(24, 24, 24, 24);
        return new Holder(tv);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder h, int i) {
        Complaint c = list.get(i);

        h.tv.setText("Материал #" + c.materialId + " | " + c.reason);

        h.tv.setOnClickListener(v -> {
            AppDatabase.getInstance(ctx)
                    .materialDao()
                    .blockMaterial(c.materialId);

            AppDatabase.getInstance(ctx)
                    .complaintDao()
                    .markProcessed(c.id);

            Toast.makeText(ctx, "Материал заблокирован", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView tv;

        Holder(@NonNull View v) {
            super(v);
            tv = (TextView) v;
        }
    }
}
