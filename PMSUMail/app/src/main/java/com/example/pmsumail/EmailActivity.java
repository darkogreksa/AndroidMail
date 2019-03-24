package com.example.pmsumail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class EmailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarText;
    private ImageView btnDeleteToolbar;
    private ImageView btnReplayAllToolbar;
    private ImageView btnReplayToolbar;
    private ImageView btnForwardToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        initViews();
        setSupportActionBar(toolbar);
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        btnDeleteToolbar = toolbar.findViewById(R.id.button_one);
        btnReplayAllToolbar = toolbar.findViewById(R.id.button_two);
        btnReplayToolbar = toolbar.findViewById(R.id.button_three);
        btnForwardToolbar = toolbar.findViewById(R.id.button_four);
        toolbarText = toolbar.findViewById(R.id.toolbar_text);

        btnDeleteToolbar.setImageDrawable(getResources().getDrawable(R.drawable.ic_delete_black_24dp));
        btnReplayAllToolbar.setImageDrawable(getResources().getDrawable(R.drawable.ic_reply_all_black_24dp));
        btnReplayToolbar.setImageDrawable(getResources().getDrawable(R.drawable.ic_reply_black_24dp));
        btnForwardToolbar.setImageDrawable(getResources().getDrawable(R.drawable.ic_forward_black_24dp));
        toolbarText.setText("Email");
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
