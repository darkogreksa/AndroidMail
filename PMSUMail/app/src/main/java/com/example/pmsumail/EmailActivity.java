package com.example.pmsumail;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pmsumail.model.Account;
import com.example.pmsumail.model.Attachment;
import com.example.pmsumail.model.Message;
import com.example.pmsumail.model.Tag;
import com.example.pmsumail.service.AccountService;
import com.example.pmsumail.service.MessageService;
import com.example.pmsumail.service.ServiceUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmailActivity extends AppCompatActivity {

    Message message = new Message();
    private Account account = new Account();
    private MessageService messageService;
    private AccountService accountService;
    private SharedPreferences sharedPreferences;
    private List<Tag> tags = new ArrayList<>();
    private List<Attachment> attachments = new ArrayList<>();
    String accountPrefe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        Toolbar toolbar = findViewById(R.id.mail_toolbar);
        setSupportActionBar(toolbar);

        String json = null;
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            json = extras.getString("Message");
        }
        message = new Gson().fromJson(json, Message.class);
        messageService = ServiceUtils.messageService;

        accountService = ServiceUtils.accountService;

        sharedPreferences = getSharedPreferences(LoginActivity.MyPres, Context.MODE_PRIVATE);

        accountPrefe = sharedPreferences.getString(LoginActivity.Username, "");

//        Call<Account> call = accountService.getByUsername(accountPrefe);
//
//        call.enqueue(new Callback<Account>() {
//            @Override
//            public void onResponse(Call<Account> call, Response<Account> response) {
//                account = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<Account> call, Throwable t) {
//
//            }
//        });

//        Call callTags = tagService.getTags();
//
//        callTags.enqueue(new Callback<List<Tag>>() {
//            @Override
//            public void onResponse(Call<List<Tag>> calltag, Response<List<Tag>> res) {
//
//                if(res.isSuccessful()){
//                    tags = res.body();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Tag>> calltag,Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

//        Call callAttachments = attachmentService.getAttachments();
//
//        callAttachments.enqueue(new Callback<List<Attachment>>() {
//            @Override
//            public void onResponse(Call<List<Attachment>> callAtt, Response<List<Attachment>> responseAtt) {
//                if(responseAtt.isSuccessful()) {
//                    attachments = responseAtt.body();
//                }
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });


//        TextView from_view = findViewById(R.id.from_view);
//        TextView to_view = findViewById(R.id.to_view);
//        TextView subject_view = findViewById(R.id.subject_view);
//        TextView cc_view = findViewById(R.id.cc_view);
//        TextView bc_view = findViewById(R.id.bc_view);
//        TextView content_view = findViewById(R.id.content_view);
//
//
//        from_view.setText(getIntent().getStringExtra("From"));
//        to_view.setText(getIntent().getStringExtra("To"));
//        subject_view.setText(getIntent().getStringExtra("Subject"));
//        cc_view.setText(getIntent().getStringExtra("CC"));
//        bc_view.setText(getIntent().getStringExtra("BC"));
//        content_view.setText(getIntent().getStringExtra("Content"));
    }

    // Meni na toolbaru
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_item_email, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Funkionalnost menija gore navedenog
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_back:
                Intent i = new Intent (this, EmailsActivity.class);
                startActivity(i);
                return true;
            case R.id.action_replay:
                Toast.makeText(getBaseContext(), "Replay" , Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.action_replayAll:
                Toast.makeText(getBaseContext(), "Replay all" , Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.action_forward:
                Toast.makeText(getBaseContext(), "Forward" , Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.action_delete:
                deleteMessage();
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, EmailsActivity.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    // Metoda koja brise izabranu poruku
    public void deleteMessage() {
        Call<Message> call = messageService.deleteMessage(message.getId());

        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {

            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
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
