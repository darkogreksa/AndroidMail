package com.example.pmsumail.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Message {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("cc")
    @Expose
    private String cc;
    @SerializedName("bcc")
    @Expose
    private String bcc;
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

    public Message() {
    }

    public Message(int id, String from, String to, String cc, String bcc, Account account, Folder folder, Date dateTime, String subject, String content, ArrayList<Attachment> attachments, ArrayList<Tag> tags) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.account = account;
        this.folder = folder;
        this.dateTime = dateTime;
        this.subject = subject;
        this.content = content;
        this.attachments = attachments;
        this.tags = tags;
    }

    public Message(String from, String to, String cc, String bcc, Account account, Folder folder, Date dateTime, String subject, String content, ArrayList<Attachment> attachments, ArrayList<Tag> tags) {
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.account = account;
        this.folder = folder;
        this.dateTime = dateTime;
        this.subject = subject;
        this.content = content;
        this.attachments = attachments;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
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

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }
}
