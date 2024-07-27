package com.example.notesapp;

import android.os.Bundle;

import com.example.notesapp.database.Note;
import com.example.notesapp.fragments.NoteEdit;
import com.example.notesapp.fragments.NotesList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.position,new NoteEdit(false)).addToBackStack("").commit();
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.position,new NotesList()).commit();
    }

}
