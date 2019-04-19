package com.example.pmsumail.model;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Date;

public class Email {
    private int id;
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private Date dateTime;
    private String subject;
    private String content;
    private Bitmap photo;
    private ArrayList<Attachment> attachments;
    private ArrayList<Tag> tags;

    public Email() {
    }

    public Email(int id, String from, String to, String cc, String bcc, Date dateTime, String subject, String content, ArrayList<Attachment> attachments, ArrayList<Tag> tags) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.dateTime = dateTime;
        this.subject = subject;
        this.content = content;
        this.attachments = attachments;
        this.tags = tags;
    }
    public Email(String from, String to, String cc, String bcc,String subject, String content, Date dateTime, Bitmap photo) {
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.content = content;
        this.dateTime = dateTime;
        this.photo = photo;
    }


    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
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
