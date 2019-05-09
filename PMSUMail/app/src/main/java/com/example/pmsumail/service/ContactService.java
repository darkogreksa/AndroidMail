package com.example.pmsumail.service;

import com.example.pmsumail.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ContactService {

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET(ServiceUtils.CONTACTS)
    Call<List<Contact>> getContacts();
}
