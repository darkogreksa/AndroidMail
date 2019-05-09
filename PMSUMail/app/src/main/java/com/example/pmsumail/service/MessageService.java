package com.example.pmsumail.service;

import com.example.pmsumail.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MessageService {

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET(ServiceUtils.MESSAGES)
    Call<List<Message>> getMessages();

    @GET(ServiceUtils.SORTMESSAGES)
    Call<List<Message>> sortMessages();

}
