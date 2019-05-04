package com.example.pmsumail;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.pmsumail.model.Account;
import com.example.pmsumail.model.Attachment;
import com.example.pmsumail.model.Contact;
import com.example.pmsumail.model.Message;
import com.example.pmsumail.model.Folder;
import com.example.pmsumail.model.Photo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UtilsDummyModels {

    public static List<Message> getMockEmails(Context context) {
        List<Message> messageList = new ArrayList<>();

        Message message = new Message();
        message.setAccount(new Account());
        message.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        message.setAccount(getMockedAccount());
        message.setContent("Test content 1");
        message.setFrom(getMockedContactPera(context));
        message.setDateTime(new Date());

        Message message2 = new Message();
        message2.setAccount(new Account());
        message2.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        message2.setAccount(getMockedAccount());
        message2.setContent("Test content 2");
        message2.setFrom(getMockedContactPera(context));
        message2.setDateTime(new Date());

        Message message3 = new Message();
        message3.setAccount(new Account());
        message3.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        message3.setAccount(getMockedAccount());
        message3.setContent("Test content 3");
        message3.setFrom(getMockedContactCosko(context));
        message3.setDateTime(new Date());

        Message message4 = new Message();
        message4.setAccount(new Account());
        message4.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        message4.setAccount(getMockedAccount());
        message4.setContent("Test content 4");
        message4.setFrom(getMockedContactHoblo(context));
        message4.setDateTime(new Date());


        messageList.add(message);
        messageList.add(message2);
        messageList.add(message3);
        messageList.add(message4);
        return messageList;
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
        folder.setMessages((ArrayList<Message>) getMockEmails(context));
        folder.setName("Folder name1");

        Folder folder2 = new Folder();
        folder2.setMessages((ArrayList<Message>) getMockEmails(context));
        folder2.setName("Folder name1");

        folderList.add(folder);
        folderList.add(folder2);

        return folderList;
    }
    public  static List<Message> getMockedMessages(Context context){
        List<Message> messagesList = new ArrayList<>();

        Message messages = new Message();
        messages.setAccount(new Account());
        messages.setAttachments((ArrayList<Attachment>) getMockedAttachment());
        messages.setAccount(getMockedAccount());
        messages.setContent("Test content 1");
        messages.setFrom(getMockedContactPera(context));
        messages.setDateTime(new Date());

        Message messages2 = new Message();
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
