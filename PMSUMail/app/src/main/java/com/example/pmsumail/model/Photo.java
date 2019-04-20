package com.example.pmsumail.model;

import android.graphics.Bitmap;

public class Photo {
    private int id;
    private String path;
    private Bitmap bitmap;

    public Photo() {
    }

    public Photo(int id,String path) {
        this.id = id;
        this.path = path;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
