package com.example.pmsumail.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Folder {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rule")
    @Expose
    private Rule rule;
    @SerializedName("subfolder")
    @Expose
    private Folder subfolder;
    @SerializedName("messages")
    @Expose
    private ArrayList<Message> messages;


    public Folder() {
    }

    public Folder(int id, String name, ArrayList<Message> messages, Folder subfolder, Rule rule) {
        this.id = id;
        this.name = name;
        this.messages = messages;
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

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
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
