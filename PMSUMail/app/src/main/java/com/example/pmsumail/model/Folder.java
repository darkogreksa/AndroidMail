package com.example.pmsumail.model;

public class Folder {

    private int id;
    private String name;
    private String messages;


    public Folder() {
    }

    public Folder(int id, String name, String messages){
        this.id = id;
        this.name = name;
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

    public String getMessages() { return messages; }

    public void setMessages(String messages) {
        this.messages = messages;
    }


}
