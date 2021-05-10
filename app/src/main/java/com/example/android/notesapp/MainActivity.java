package com.example.android.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android.notesapp.data.MyDbHelper;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NotesAdapter notesAdapter;
    MyDbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDbHelper = new MyDbHelper(MainActivity.this);
        recyclerView = findViewById(R.id.notes_recycler_view);
        notesAdapter = new NotesAdapter(MainActivity.this, myDbHelper);
        recyclerView.setAdapter(notesAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

    }
}