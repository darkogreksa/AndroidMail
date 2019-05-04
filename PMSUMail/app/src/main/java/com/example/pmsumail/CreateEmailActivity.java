package com.example.pmsumail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateEmailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarText;
    private ImageView btnSend;
    private ImageView btnCancel;

    public CreateEmailActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_email);
        initView();


        setSupportActionBar(toolbar);
    }
    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        btnSend = findViewById(R.id.button_one);
        btnCancel = findViewById(R.id.button_two);
        toolbarText = findViewById(R.id.toolbar_text);

        btnSend.setImageDrawable(getResources().getDrawable(R.drawable.ic_send));
        btnCancel.setImageDrawable(getResources().getDrawable(R.drawable.ic_cancel));
        toolbarText.setText("Create message");

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
