package com.example.pmsumail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView btnLogout;
    private TextView toolbarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();

        setSupportActionBar(toolbar);
    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        btnLogout = toolbar.findViewById(R.id.button_one);
        toolbarText = toolbar.findViewById(R.id.toolbar_text);

        btnLogout.setImageDrawable(getResources().getDrawable(R.drawable.ic_icon));
        toolbarText.setText("Profile");
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
