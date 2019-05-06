package com.example.pmsumail.service;

import com.example.pmsumail.model.Attachment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AttachmentService {

    @Headers({
            "User-Agent: Mobile-Android",
            "Content-Type:application/json"
    })
    @GET(ServiceUtils.ATTACHMENTS)
    Call<List<Attachment>> getAttachments();

    @GET(ServiceUtils.ATTACHMENTID)
    Call<Attachment> getAttachment(@Path("id") int id);

    @POST(ServiceUtils.ATTACHMENTADD)
    Call<Attachment> addAttachment(@Body Attachment attachment);
}
