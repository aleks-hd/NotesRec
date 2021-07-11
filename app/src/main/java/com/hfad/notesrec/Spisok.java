package com.hfad.notesrec;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Spisok extends RecyclerView.Adapter<Spisok.ViewHolder> {

    private ArrayList<Note> arrayList;

    private OnItemClickListener itemClickListener;

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
        holder.getImage().setImageResource(name.getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private AppCompatImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imagecontainerItem);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener !=null){
                        itemClickListener.onItemClick(view, getAdapterPosition());
                    }
                }
            });


        }

        public TextView getTextView() {
            return textView;
        }
        public AppCompatImageView getImage() {
            return imageView;
        }
    }




}
