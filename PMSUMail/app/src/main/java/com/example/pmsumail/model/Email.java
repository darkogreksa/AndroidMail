package com.example.pmsumail.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Email {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("from")
    @Expose
    private Contact from;
    @SerializedName("to")
    @Expose
    private Contact to;
    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("folder")
    @Expose
    private Folder folder;
    @SerializedName("dateTime")
    @Expose
    private Date dateTime;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("attachments")
    @Expose
    private ArrayList<Attachment> attachments;
    @SerializedName("tags")
    @Expose
    private ArrayList<Tag> tags;

    public Email() {
    }

    public Email(int id, Contact from, Contact to,Date dateTime, String subject, String content, ArrayList<Attachment> attachments, ArrayList<Tag> tags) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.dateTime = dateTime;
        this.subject = subject;
        this.content = content;
        this.attachments = attachments;
        this.tags = tags;
    }
    public Email(Contact from, Contact to, String cc, String bcc,String subject, String content, Date dateTime, Bitmap photo) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.dateTime = dateTime;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact getFrom() {
        return from;
    }

    public void setFrom(Contact from) {
        this.from = from;
    }

    public Contact getTo() {
        return to;
    }

    public void setTo(Contact to) {
        this.to = to;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Attachment> attachments) {
        this.attachments = attachments;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
}
