package com.example.notesbygrenka;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesLayout extends RecyclerView.Adapter<NotesLayout.MyViewHolder>{

    private ArrayList<String> notes = new ArrayList<>();

    public void setData(ArrayList<String> notes) {
        this.notes = notes;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String NowText = notes.get(position);
        holder.getNoteText().setText(NowText);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView getNoteText() {
            return NoteText;
        }

        public void setNoteText(TextView noteText) {
            NoteText = noteText;
        }

        private TextView NoteText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            NoteText = itemView.findViewById(R.id.textView);
        }

    }
}