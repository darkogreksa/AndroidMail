package com.example.pmsumail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class ProfileActivity extends AppCompatActivity {

    private NavigationView navigation;
    private TextView textViewUsername;
    private TextView textViewEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //initView();


        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_item_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }


/*
    private void initView() {
        textViewUsername = findViewById(R.id.text_view_username);
        textViewEmail = findViewById(R.id.email_text_view);
        textViewUsername.setText("Username: " + UtilsDummyModels.getMockedAccount().getUsername());
        textViewEmail.setText("Message: " + UtilsDummyModels.getMockedAccount().getMessages());
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                Intent i = new Intent(this, LoginActivity.class);
                Toast.makeText(getBaseContext(), "Log out" , Toast.LENGTH_SHORT ).show();
                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);
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
