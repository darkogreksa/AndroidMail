package com.example.pmsumail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmsumail.model.Contact;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateContactActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView btnSave;
    private ImageView btnCancel;
    private TextView toolbarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        initView();

        setSupportActionBar(toolbar);
    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        btnCancel = findViewById(R.id.button_one);
        btnSave = findViewById(R.id.button_two);
        toolbarText = findViewById(R.id.toolbar_text);

        btnSave.setImageDrawable(getResources().getDrawable(R.drawable.ic_save));
        btnCancel.setImageDrawable(getResources().getDrawable(R.drawable.ic_cancel));
        toolbarText.setText("Create contact");

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
