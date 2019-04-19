package com.example.pmsumail.model;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Contact {
    private int id;
    private String firstname;
    private String lastname;
    private String display;
    private String email;
    private Bitmap photo;
    private ArrayList<Email> emails;

    public Contact() {
    }

    public Contact(int id, String firstname, String lastname, String display, String email, Bitmap photo, ArrayList<Email> emails) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.display = display;
        this.email = email;
        this.photo = photo;
        this.emails = emails;
    }

    public ArrayList<Email> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<Email> emails) {
        this.emails = emails;
    }

    public Contact(String firstname, String lastname, String display, String email, Bitmap photo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.display = display;
        this.email = email;
        this.photo = photo;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Bitmap getPhoto() { return photo;
    }

    public void setPhoto(Bitmap photo) { this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
