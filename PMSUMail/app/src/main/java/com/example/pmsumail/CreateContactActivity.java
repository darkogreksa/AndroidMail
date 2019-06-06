package com.example.pmsumail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pmsumail.model.Contact;
import com.example.pmsumail.service.ContactService;
import com.example.pmsumail.service.ServiceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateContactActivity extends AppCompatActivity {

    private EditText firstname;
    private EditText lastname;
    private EditText email;

    private ContactService contactService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        initView();

        Toolbar toolbar = findViewById(R.id.contact_toolbar);
        setSupportActionBar(toolbar);
    }

    private void initView() {
        firstname = findViewById(R.id.first_name);
        lastname = findViewById(R.id.last_name);
        email = findViewById(R.id.email_edit);

        contactService = ServiceUtils.contactService;

    }


    private void createContact() {
        Contact contact = new Contact();
        contact.setEmail(email.getText().toString());
        contact.setFirstname(firstname.getText().toString());
        contact.setLastname(lastname.getText().toString());
        contact.setDisplay("display1");
        contact.setNote("note1");


       if (email.getText().toString().isEmpty() || firstname.getText().toString().isEmpty() || lastname.toString().isEmpty()) {
            Toast.makeText(this, "Some editText is empty!", Toast.LENGTH_SHORT).show();
            return;
        }


        Call<Contact> contactCall = contactService.addContact(contact);
        contactCall.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                Toast.makeText(CreateContactActivity.this, "Contact created", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                Toast.makeText(CreateContactActivity.this, "Failed to create contact", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_item_create_contact, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_back:
                onBackPressed();
                return true;
            case R.id.action_save:
                createContact();
        }
        return super.onOptionsItemSelected(item);
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
