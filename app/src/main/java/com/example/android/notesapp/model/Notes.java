package com.example.android.notesapp.model;

public class Notes {
    private int id;
    private String notes_title;
    private String notes_body;
    private String notes_date;

    public Notes(String notes_title, String notes_body, String notes_date) {
        this.notes_title = notes_title;
        this.notes_body = notes_body;
        this.notes_date = notes_date;
    }

    public Notes(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotes_title() {
        return notes_title;
    }

    public void setNotes_title(String notes_title) {
        this.notes_title = notes_title;
    }

    public String getNotes_body() {
        return notes_body;
    }

    public void setNotes_body(String notes_body) {
        this.notes_body = notes_body;
    }

    public String getNotes_date() {
        return notes_date;
    }

    public void setNotes_date(String notes_date) {
        this.notes_date = notes_date;
    }

}
