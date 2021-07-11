package com.hfad.notesrec;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Spisok extends RecyclerView.Adapter<Spisok.ViewHolder> {

    private ArrayList<Note> arrayList;

    public Spisok(ArrayList<Note> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Spisok.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Spisok.ViewHolder holder, int position) {
        Note name = arrayList.get(position);
        holder.getTextView().setText(name.getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private AppCompatImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imagecontainerItem);
            initonClick(imageView,textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    private void initonClick(AppCompatImageView imageView, TextView textView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click",   "onClick");
            }
        });
    }


}
