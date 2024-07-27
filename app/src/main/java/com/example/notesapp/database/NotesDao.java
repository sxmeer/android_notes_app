package com.example.notesapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NotesDao {
    @Insert
    void insert(Note note);

    @Query("select * from note")
    LiveData<List<Note>> getAllNotes();

    @Query("select * from note where id=:id")
    Note getNote(int id);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);
}
