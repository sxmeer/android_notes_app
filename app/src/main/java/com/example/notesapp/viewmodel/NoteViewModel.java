package com.example.notesapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notesapp.database.DatabaseClient;
import com.example.notesapp.database.Note;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    Application application;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public LiveData<List<Note>> getAllNotes(){
        return DatabaseClient.getDatabaseClient(application).getAppDatabase().notesDao().getAllNotes();
    }
}
