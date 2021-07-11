package com.hfad.notesrec;

public class Note {
    private String Name;

    public Note() {
    }

    public Note(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    private Integer image;
}
