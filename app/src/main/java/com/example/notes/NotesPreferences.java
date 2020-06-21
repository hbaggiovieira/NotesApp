package com.example.notes;

import android.content.Context;
import android.content.SharedPreferences;

public class NotesPreferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NAME_FILE = "notes.preferences";
    private final String NAME_KEY = "name";

    public NotesPreferences(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NAME_FILE, 0); //recuperar anotação
        editor = preferences.edit(); // salvar anotação
    }

    public void saveNote (String note) {
        editor.putString(NAME_KEY, note);
        editor.commit();
    }

    public String recoveryNote () {
        return preferences.getString(NAME_KEY, "");
    }

}
