package com.example.pmsumail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmsumail.model.Message;
import com.example.pmsumail.model.Tag;
import com.example.pmsumail.service.MessageService;

public class CreateEmailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarText;
    private ImageView btnSend;
    private ImageView btnCancel;
    private EditText tagText;
    private static Tag tag = new Tag();
    private TagService tagService;
    private MessageService messageService;
    private static Tag tagBody = new Tag();
    private static Message messageBody;

    public CreateEmailActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_email);
        initView();


        setSupportActionBar(toolbar);
    }

//    public void addTag(){
//        String tagString = tagText.getText().toString().trim();
//        String[] separator = tagString.split("#");
//
//        List<String> tagFilter = Arrays.asList(separator);
//        for (String tagStrings : tagFilter.subList(1, tagFilter.size())){
//            tag.setName(tagString);
//
//            Call<Tag> call = tagService.addTag(tag);
//            call.enqueue(new Callback<Tag>() {
//                @Override
//                public void onResponse(Call<Tag> call, Response<Tag> response) {
//                    tagBody = response.body();
//                    addTagInMessage(messageBody.getId(), tagBody.getId());
//                }
//
//                @Override
//                public void onFailure(Call<Tag> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(), "Greska", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }
//
//    public void addTagInMessage(int messageId, int tagId){
//        Call<Message> call = messageService.addTagInMessage(messageBody.getId(), tagBody.getId());
//
//        call.enqueue(new Callback<Message>() {
//            @Override
//            public void onResponse(Call<Message> call, Response<Message> response) {
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Message> call, Throwable t) {
//
//            }
//        });
//    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        btnSend = findViewById(R.id.button_one);
        btnCancel = findViewById(R.id.button_two);
        toolbarText = findViewById(R.id.toolbar_text);

        btnSend.setImageDrawable(getResources().getDrawable(R.drawable.ic_send));
        btnCancel.setImageDrawable(getResources().getDrawable(R.drawable.ic_cancel));
        toolbarText.setText("Create message");

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
