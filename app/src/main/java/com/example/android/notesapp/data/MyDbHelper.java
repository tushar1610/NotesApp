package com.example.android.notesapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.android.notesapp.model.Notes;
import com.example.android.notesapp.params.Params;

public class MyDbHelper extends SQLiteOpenHelper {
    public MyDbHelper(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + Params.TABLE_NAME + "("
                + Params.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Params.KEY_NOTE_TITLE + "TEXT, " + Params.KEY_NOTES_BODY + "TEXT, " +
                Params.KEY_NOTES_DATE + "TEXT " +
                ")";
        Log.d("Create table", create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addNote(Notes notes){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.KEY_NOTE_TITLE, notes.getNotes_title());
        values.put(Params.KEY_NOTES_BODY, notes.getNotes_body());
        values.put(Params.KEY_NOTES_BODY, notes.getNotes_date());

        database.insert(Params.TABLE_NAME, null, values);
        Log.d("Insert", "Insert successful");
        database.close();
    }

    public void deleteNote(Notes note){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(Params.TABLE_NAME, Params.KEY_ID + "=?" , new String[]{String.valueOf(note.getId())});
        database.close();
    }

    public int getCount(){
        SQLiteDatabase database = this.getReadableDatabase();
        String query = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor = database.rawQuery(query, null);
        return cursor.getCount();
    }

    public int updateNote(Notes note){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NOTE_TITLE, note.getNotes_title());
        values.put(Params.KEY_NOTES_BODY, note.getNotes_body());
        values.put(Params.KEY_NOTES_DATE, note.getNotes_date());
        int rowsUpdated = database.update(Params.TABLE_NAME, values, Params.KEY_ID + " =? ", new String[]{String.valueOf(note.getId())});
        database.close();
        return rowsUpdated;
    }

    public Notes getNote(int position){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + Params.TABLE_NAME, null);
        if (cursor.moveToPosition(position)){
            return new Notes(cursor.getString(1), cursor.getString(2), cursor.getString(3));
        }
        return null;
    }
}
