package com.example.pmsumail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EmailsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button contactBtn;
    private Button contactsBtn;
    private Button createContactBtn;
    private Button createEmailBtn;
    private Button emailBtn;
    private Button createFolderBtn;
    private Button folderBtn;
    private Button foldersBtn;
    private Button profileBtn;
    private Button settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails);
        initViews();
    }

    private void initViews() {
        contactBtn = findViewById(R.id.contact_btn);
        contactsBtn = findViewById(R.id.contacts_btn);
        createContactBtn = findViewById(R.id.create_contact_btn);
        createEmailBtn = findViewById(R.id.create_email_btn);
        emailBtn = findViewById(R.id.email_btn);
        createFolderBtn = findViewById(R.id.create_folder_btn);
        folderBtn = findViewById(R.id.folder_btn);
        foldersBtn = findViewById(R.id.folders_btn);
        profileBtn = findViewById(R.id.profile_btn);
        settingsBtn = findViewById(R.id.settings_btn);

        contactBtn.setOnClickListener(this);
        contactsBtn.setOnClickListener(this);
        createContactBtn.setOnClickListener(this);
        createEmailBtn.setOnClickListener(this);
        emailBtn.setOnClickListener(this);
        createFolderBtn.setOnClickListener(this);
        folderBtn.setOnClickListener(this);
        foldersBtn.setOnClickListener(this);
        profileBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == contactBtn.getId()) {
            startActivity(new Intent(this, ContactActivity.class));
        } else if (view.getId() == contactsBtn.getId()) {
            startActivity(new Intent(this, ContactsActivity.class));
        } else if (view.getId() == createContactBtn.getId()) {
            startActivity(new Intent(this, CreateContactActivity.class));
        } else if (view.getId() == createEmailBtn.getId()) {
            startActivity(new Intent(this, CreateEmailActivity.class));
        } else if (view.getId() == emailBtn.getId()) {
            startActivity(new Intent(this, EmailActivity.class));
        } else if (view.getId() == createFolderBtn.getId()) {
            startActivity(new Intent(this, CreateFolderActivity.class));
        } else if (view.getId() == folderBtn.getId()) {
            startActivity(new Intent(this, FolderActivity.class));
        } else if (view.getId() == foldersBtn.getId()) {
            startActivity(new Intent(this, FoldersActivity.class));
        } else if (view.getId() == profileBtn.getId()) {
            startActivity(new Intent(this, ProfileActivity.class));
        } else if (view.getId() == settingsBtn.getId()) {
            startActivity(new Intent(this, SettingsActivity.class));
        }

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
