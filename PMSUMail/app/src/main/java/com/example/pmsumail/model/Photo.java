package com.example.pmsumail.model;

import android.graphics.Bitmap;

public class Photo {
    private int id;
    private Bitmap photo;

    public Photo() {
    }

    public Photo(int id, Bitmap photo) {
        this.id = id;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}
