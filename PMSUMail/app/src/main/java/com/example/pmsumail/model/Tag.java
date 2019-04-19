package com.example.pmsumail.model;

import java.util.ArrayList;

public class Tag {
    private int id;
    private String name;
    private ArrayList<Email> emails;

    public Tag() {
    }

    public Tag(int id, String name, ArrayList<Email> emails) {
        this.id = id;
        this.name = name;
        this.emails = emails;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
