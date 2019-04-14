package com.example.pmsumail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class FolderActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarText;
    private ImageView btnEdit;
    private String folderName;
    private TextView folderTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);
        getData();
        initViews();

        setSupportActionBar(toolbar);
    }

    private void getData() {
        Intent intent = getIntent();
        folderName = intent.getStringExtra("Folder_name");
        Toast.makeText(this, "TOAST", Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        btnEdit = toolbar.findViewById(R.id.button_one);
        toolbarText = toolbar.findViewById(R.id.toolbar_text);
        folderTitle = findViewById(R.id.folder_title);

        btnEdit.setImageDrawable(getResources().getDrawable(R.drawable.ic_edit));
        toolbarText.setText("Folder");
        folderTitle.setText(folderName);

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
