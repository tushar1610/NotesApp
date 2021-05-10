package com.example.android.notesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.notesapp.data.MyDbHelper;
import com.example.android.notesapp.model.Notes;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    Context context;
    MyDbHelper myDbHelper;

    public NotesAdapter(Context context, MyDbHelper myDbHelper){
        this.context = context;
        this.myDbHelper = myDbHelper;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notes_layout, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {
        Notes notes = myDbHelper.getNote(position);
        holder.title.setText(notes.getNotes_title());
        holder.body.setText(notes.getNotes_body());
        holder.date.setText(notes.getNotes_body());
    }

    @Override
    public int getItemCount() {
        return myDbHelper.getCount();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView title, body, date;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.notes_title_rv);
            body = itemView.findViewById(R.id.notes_body_rv);
            date = itemView.findViewById(R.id.notes_date_rv);
        }
    }
}
