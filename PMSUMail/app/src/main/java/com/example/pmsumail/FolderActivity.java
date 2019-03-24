package com.example.pmsumail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


public class FolderActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarText;
    private ImageView btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);
        initViews();

        setSupportActionBar(toolbar);
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        btnEdit = toolbar.findViewById(R.id.button_one);
        toolbarText = toolbar.findViewById(R.id.toolbar_text);

        btnEdit.setImageDrawable(getResources().getDrawable(R.drawable.ic_edit));
        toolbarText.setText("Folder");

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
