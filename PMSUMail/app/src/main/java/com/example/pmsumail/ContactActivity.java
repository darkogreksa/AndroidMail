package com.example.pmsumail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmsumail.model.Contact;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        AppBarLayout appBarLayout = findViewById(R.id.appbar);

        Toolbar toolbar = findViewById(R.id.contact_toolbar);
        setSupportActionBar(toolbar);

        TextView firstname_view = findViewById(R.id.firstname_view);
        TextView lastname_view = findViewById(R.id.lastname_view);
        TextView email_view = findViewById(R.id.email_view);

        firstname_view.setText(getIntent().getStringExtra("First name"));
        lastname_view.setText(getIntent().getStringExtra("Last name"));
        email_view.setText(getIntent().getStringExtra("Message"));
    }

    //tekst koji se ispisuje na toolbar-u
    @Override
    public void setTitle(CharSequence title) {
        CharSequence mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    //meni na toolbaru, odnosno ikonice za prelazak na ostale aktivnosti
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_item_contact, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //funkcionalnost opcija iz menija gore navedenog
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(this, SettingsActivity.class);
                startActivity(i);
                return true;
            case R.id.action_save:
                Snackbar.make(findViewById(R.id.action_save),"Saved",Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.action_back:
                Intent in = new Intent(this, ContactsActivity.class);
                startActivity(in);
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
        finish();
        startActivity(getIntent());
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
