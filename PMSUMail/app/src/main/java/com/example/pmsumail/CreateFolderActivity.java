package com.example.pmsumail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateFolderActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarText;
    private ImageView btnSave;
    private ImageView btnCancel;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_folder);
        initView();

        setSupportActionBar(toolbar);


    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        btnSave = toolbar.findViewById(R.id.button_one);
        btnCancel = toolbar.findViewById(R.id.button_two);
        btnBack = toolbar.findViewById(R.id.button_three);
        toolbarText = toolbar.findViewById(R.id.toolbar_text);

        btnSave.setImageDrawable(getResources().getDrawable(R.drawable.ic_save));
        btnCancel.setImageDrawable(getResources().getDrawable(R.drawable.ic_cancel_black_24dp));
        btnBack.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
        toolbarText.setText("Create folder");


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
