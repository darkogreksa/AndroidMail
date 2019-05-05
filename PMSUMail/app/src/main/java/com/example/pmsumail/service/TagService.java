package com.example.pmsumail.service;

import com.example.pmsumail.model.Tag;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TagService {

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET(ServiceUtils.TAGS)
    Call<List<Tag>> getTags();

    @GET(ServiceUtils.GETTAGBYMESSAGE)
    Call<List<Tag>> getTagByMessage(@Path("id") int id);

    @GET("tags/name/{id}")
    Call<Tag> getTagByName(@Path("name") String name);

    @POST("tags")
    Call<Tag> addTag(@Body Tag tag);
}
