package com.example.pmsumail.model;

public class Contact {
    public enum Format {
        PLAIN,
        HTML
    }
    private int id;
    private String firstname;
    private String lastname;
    private String display;
    private String email;
    private Photo photo;
    private Format f;

    public Contact() {
    }

        public Contact(int id, String firstname, String lastname, String display, String email,Photo photo, Format f ){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.display = display;
        this.email = email;
        this.photo = photo;
        this.f = f;
    }



    public Contact(String firstname, String lastname, String display, String email, Photo photo) {
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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Format getF() {
        return f;
    }

    public void setF(Format f) {
        this.f = f;
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
