package com.example.notesapp.fragments;


import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notesapp.R;
import com.example.notesapp.database.DatabaseClient;
import com.example.notesapp.database.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteEdit extends Fragment {
    Button save,cancel;
    EditText title,description;
    boolean isEdit;

    public NoteEdit(boolean isEdit){
        this.isEdit = isEdit;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        save = getView().findViewById(R.id.button2);
        cancel = getView().findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateTolist();
            }
        });
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        fab.hide();
    }
    private void validation(){
        title = getView().findViewById(R.id.editText);
        description = getView().findViewById(R.id.editText2);

        if(title.getText().toString().trim().isEmpty()){
            Toast.makeText(getContext(),"enter title",Toast.LENGTH_LONG).show();
            return;
        }

        if(description.getText().toString().trim().isEmpty()){
            Toast.makeText(getContext(),"enter description",Toast.LENGTH_LONG).show();
            return;
        }
        final Note note = new Note(title.getText().toString().trim(),description.getText().toString().trim());
        class StoreDescription extends AsyncTask<Void, Void, Void>{
            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getDatabaseClient(getContext()).getAppDatabase().notesDao().insert(note);
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getContext(),"Notes Saved Successfully",Toast.LENGTH_LONG).show();
                navigateTolist();
            }
        }
        StoreDescription storeDescription = new StoreDescription();
        storeDescription.execute();
    }
    private void navigateTolist(){
        getActivity().getSupportFragmentManager().popBackStack();
    }
}
