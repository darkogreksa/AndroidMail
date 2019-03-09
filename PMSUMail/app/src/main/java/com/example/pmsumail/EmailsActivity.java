package com.example.pmsumail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmailsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button contactBtn;
    private Button createContactBtn;
    private Button createEmailBtn;
    private Button createFolderBtn;
    private Button foldersBtn;
    private Button profileBtn;
    private Button settingsBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails);
        initViews();
    }

    private void initViews(){
        contactBtn = findViewById(R.id.contact_btn);
        createContactBtn = findViewById(R.id.create_contact_btn);
        createEmailBtn = findViewById(R.id.email_btn);
        createFolderBtn = findViewById(R.id.create_folder_btn);
        foldersBtn = findViewById(R.id.folders_btn);
        profileBtn = findViewById(R.id.profile_btn);
        settingsBtn = findViewById(R.id.settings_btn);

        contactBtn.setOnClickListener(this);
        createContactBtn.setOnClickListener(this);
        createEmailBtn.setOnClickListener(this);
        createFolderBtn.setOnClickListener(this);
        foldersBtn.setOnClickListener(this);
        profileBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == contactBtn.getId()){
            startActivity(new Intent(this, ContactActivity.class));
        }else if (view.getId() == createContactBtn.getId()) {
            startActivity(new Intent(this, CreateContactActivity.class));
        }else if (view.getId() == createEmailBtn.getId()){
                startActivity(new Intent(this, CreateEmailActivity.class));
        }else if (view.getId() == createFolderBtn.getId()){
            startActivity(new Intent(this, CreateFolderActivity.class));
        }else if (view.getId() == foldersBtn.getId()){
            startActivity(new Intent(this, FolderActivity.class));
        }else if (view.getId() ==  profileBtn.getId()){
            startActivity(new Intent(this, ProfileActivity.class));
        }else if(view.getId() == settingsBtn.getId()){
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
