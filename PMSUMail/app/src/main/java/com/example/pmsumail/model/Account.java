package com.example.pmsumail.model;

import java.util.ArrayList;

public class Account {
    private int id;
    private String smtp;
    private String pop3;
    private String username;
    private String password;
    private ArrayList<Email> emails;

    public Account() {
    }

    public Account(int id, String smtp, String pop3, String username, String password, ArrayList<Email> emails) {
        this.id = id;
        this.smtp = smtp;
        this.pop3 = pop3;
        this.username = username;
        this.password = password;
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

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getPop3() {
        return pop3;
    }

    public void setPop3(String pop3) {
        this.pop3 = pop3;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
