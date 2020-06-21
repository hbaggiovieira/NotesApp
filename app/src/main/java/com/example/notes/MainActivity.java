package com.example.notes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private NotesPreferences preferences;
    private EditText editNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNote = findViewById(R.id.editNote);

        preferences = new NotesPreferences(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textRecovery = editNote.getText().toString();
                if (textRecovery.equals("")) {
                    Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG)
                            .show();
                } else {
                    preferences.saveNote(textRecovery);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG)
                            .show();
                }


            }
        });

        //Recuperar a anotação
        String note = preferences.recoveryNote();
        if (!note.equals("")) {
            editNote.setText(note);
        }

    }
}