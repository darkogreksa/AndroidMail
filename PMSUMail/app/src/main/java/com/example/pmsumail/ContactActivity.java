package com.example.pmsumail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarText;
    private ImageView btnBack;
    private ImageView btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initView();


        setSupportActionBar(toolbar);
    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        btnBack = findViewById(R.id.button_four);
        btnSave = findViewById(R.id.button_one);
        toolbarText = findViewById(R.id.toolbar_text);

        btnBack.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
        btnSave.setImageDrawable(getResources().getDrawable(R.drawable.ic_save));
        toolbarText.setText("Contact");



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
