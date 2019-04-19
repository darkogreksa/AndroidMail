package com.example.pmsumail.model;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Folder {

    private int id;
    private Bitmap photo;
    private String name;
    private String messages;
    private ArrayList<Email> emails;
    private ArrayList<Folder> folders;


    public Folder() {
    }

    public Folder(int id, String name, String messages, Bitmap photo, ArrayList<Email> emails, ArrayList<Folder> folders) {
        this.id = id;
        this.name = name;
        this.messages = messages;
        this.emails = emails;
        this.folders = folders;
        this.photo = photo;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public ArrayList<Folder> getFolders() {
        return folders;
    }

    public void setFolders(ArrayList<Folder> folders) {
        this.folders = folders;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }

    public Folder(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessages() { return messages; }

    public void setMessages(String messages) {
        this.messages = messages;
    }


}
