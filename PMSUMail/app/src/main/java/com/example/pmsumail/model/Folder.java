package com.example.pmsumail.model;

import java.util.ArrayList;

public class Folder {

    private int id;
    private String name;
    private Rule rule;
    private Folder subfolder;
    private ArrayList<Email> emails;


    public Folder() {
    }

    public Folder(int id, String name, ArrayList<Email> emails,Folder subfolder, Rule rule) {
        this.id = id;
        this.name = name;
        this.emails = emails;
        this.subfolder = subfolder;
        this.rule = rule;
    }



    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Folder getSubfolder() {
        return subfolder;
    }

    public void setSubfolder(Folder subfolder) {
        this.subfolder = subfolder;
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


}
