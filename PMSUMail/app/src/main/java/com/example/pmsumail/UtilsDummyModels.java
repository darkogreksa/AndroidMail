package com.example.pmsumail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.pmsumail.model.Account;
import com.example.pmsumail.model.Attachment;
import com.example.pmsumail.model.Contact;
import com.example.pmsumail.model.Email;
import com.example.pmsumail.model.Folder;
import com.example.pmsumail.model.Photo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtilsDummyModels {

    public static List<Email> getMockEmails(Context context) {
        List<Email> emailList = new ArrayList<>();

        Email email = new Email();
        email.setAccount(new Account());
        email.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        email.setAccount(getMockedAccount());
        email.setContent("Test content 1");
        email.setFrom(getMockedContactPera(context));
        email.setDateTime(new Date());

        Email email2 = new Email();
        email2.setAccount(new Account());
        email2.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        email2.setAccount(getMockedAccount());
        email2.setContent("Test content 2");
        email2.setFrom(getMockedContactPera(context));
        email2.setDateTime(new Date());

        Email email3 = new Email();
        email3.setAccount(new Account());
        email3.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        email3.setAccount(getMockedAccount());
        email3.setContent("Test content 3");
        email3.setFrom(getMockedContactCosko(context));
        email3.setDateTime(new Date());

        Email email4 = new Email();
        email4.setAccount(new Account());
        email4.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        email4.setAccount(getMockedAccount());
        email4.setContent("Test content 4");
        email4.setFrom(getMockedContactHoblo(context));
        email4.setDateTime(new Date());


        emailList.add(email);
        emailList.add(email2);
        emailList.add(email3);
        emailList.add(email4);
        return emailList;
    }

    public static Contact getMockedContactPera(Context context) {
        List<Contact> contactList = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.paul);

        Contact contact = new Contact();
        contact.setPhoto(new Photo());
        contact.setFirstname("Pera");
        contact.setLastname("Peric");
        contact.setEmail("peraperic@gmail.com");
        contact.getPhoto().setBitmap(bitmap);
        return contact;
    }

    public static Contact getMockedContactStefan(Context context) {
        List<Contact> contactList = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.carl);

        Contact contact = new Contact();
        contact.setPhoto(new Photo());
        contact.setFirstname("Stefan");
        contact.setLastname("Stefanovic");
        contact.setEmail("stefan@gmail.com");
        contact.getPhoto().setBitmap(bitmap);
        return contact;
    }

    public static Contact getMockedContactCosko(Context context) {
        List<Contact> contactList = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.deborah);

        Contact contact = new Contact();
        contact.setPhoto(new Photo());
        contact.setFirstname("Cosko");
        contact.setLastname("Coskovic");
        contact.setEmail("cosko@gmail.com");
        contact.getPhoto().setBitmap(bitmap);
        return contact;
    }

    public static Contact getMockedContactHoblo(Context context) {
        List<Contact> contactList = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.paul);

        Contact contact = new Contact();
        contact.setPhoto(new Photo());
        contact.setFirstname("Hoblo");
        contact.setLastname("Hoblovic");
        contact.setEmail("hoblo@gmail.com");
        contact.getPhoto().setBitmap(bitmap);
        return contact;
    }


    public static List<Contact> getMockedContacts(Context context){
        List<Contact> contactList = new ArrayList<>();

        contactList.add(getMockedContactPera(context));
        contactList.add(getMockedContactStefan(context));
        contactList.add(getMockedContactCosko(context));
        contactList.add(getMockedContactHoblo(context));

        return  contactList;

    }

    public static Account getMockedAccount(){
        Account account = new Account();
        account.setUsername("Pera");
        account.setEmail("peraperic@gmail.com");
        return account;
    }
    public static List<Attachment> getMockedAttachment(){
        List<Attachment> listAtachments = new ArrayList<>();

        Attachment attachment = new Attachment();
        attachment.setName("Test attachment1");

        Attachment attachment1 = new Attachment();
        attachment1.setName("Test attachment2");

        listAtachments.add(attachment);
        listAtachments.add(attachment1);

        return listAtachments;
    }

    public  static List<Folder> getMockedFolders(Context context){
        List<Folder> folderList = new ArrayList<>();

        Folder folder = new Folder();
        folder.setEmails((ArrayList<Email>) getMockEmails(context));
        folder.setName("Folder name1");

        Folder folder2 = new Folder();
        folder2.setEmails((ArrayList<Email>) getMockEmails(context));
        folder2.setName("Folder name1");

        folderList.add(folder);
        folderList.add(folder2);

        return folderList;
    }
    public  static List<Email> getMockedMessages(Context context){
        List<Email> messagesList = new ArrayList<>();

        Email messages = new Email();
        messages.setAccount(new Account());
        messages.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        messages.setAccount(getMockedAccount());
        messages.setContent("Test content 1");
        messages.setFrom(getMockedContactPera(context));
        messages.setDateTime(new Date());

        Email messages2 = new Email();
        messages2.setAccount(new Account());
        messages2.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        messages2.setAccount(getMockedAccount());
        messages2.setContent("Test content 1");
        messages2.setFrom(getMockedContactPera(context));
        messages2.setDateTime(new Date());

        messagesList.add(messages);
        messagesList.add(messages);
        return messagesList;
    }


}
