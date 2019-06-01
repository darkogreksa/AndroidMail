package com.example.pmsumail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmsumail.model.Contact;
import com.example.pmsumail.model.Folder;
import com.example.pmsumail.model.requestbody.FolderRequestBody;
import com.example.pmsumail.service.ContactService;
import com.example.pmsumail.service.ServiceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateContactActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView btnSave;
    private ImageView btnCancel;
    private TextView toolbarText;
    private Button createContanctBtn;

    private EditText firstname;
    private EditText lastname;
    private EditText email;

    private ContactService contactService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        initView();

        setSupportActionBar(toolbar);
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        btnCancel = findViewById(R.id.button_one);
        btnSave = findViewById(R.id.button_two);
        toolbarText = findViewById(R.id.toolbar_text);
        firstname = findViewById(R.id.first_name);
        lastname = findViewById(R.id.last_name);
        email = findViewById(R.id.email_edit);
        createContanctBtn = findViewById(R.id.button_create_contact);

        btnSave.setImageDrawable(getResources().getDrawable(R.drawable.ic_save));
        btnCancel.setImageDrawable(getResources().getDrawable(R.drawable.ic_cancel));
        toolbarText.setText("Create contact");
        contactService = ServiceUtils.contactService;

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFolder();
            }
        });

        createContanctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFolder();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void createFolder() {
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
                Toast.makeText(CreateContactActivity.this, "Faield to create contact", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
