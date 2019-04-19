package com.example.pmsumail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmsumail.model.Email;

public class EmailActivity extends AppCompatActivity {

    Email email = new Email();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        AppBarLayout appBarLayout = findViewById(R.id.appbar);

        Toolbar toolbar = findViewById(R.id.mail_toolbar);
        setSupportActionBar(toolbar);


        TextView from_view = findViewById(R.id.from_view);
        TextView to_view = findViewById(R.id.to_view);
        TextView subject_view = findViewById(R.id.subject_view);
        TextView cc_view = findViewById(R.id.cc_view);
        TextView bc_view = findViewById(R.id.bc_view);
        TextView content_view = findViewById(R.id.content_view);


        from_view.setText(getIntent().getStringExtra("From"));
        to_view.setText(getIntent().getStringExtra("To"));
        subject_view.setText(getIntent().getStringExtra("Subject"));
        cc_view.setText(getIntent().getStringExtra("CC"));
        bc_view.setText(getIntent().getStringExtra("BC"));
        content_view.setText(getIntent().getStringExtra("Content"));






    }

    @Override
    public void setTitle(CharSequence title){
        CharSequence mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_item_email, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_back:
                Intent i = new Intent (this, EmailsActivity.class);
                startActivity(i);
                return true;
            case R.id.action_replay:
                Toast.makeText(getBaseContext(), "Replay" , Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.action_replayAll:
                Toast.makeText(getBaseContext(), "Replay all" , Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.action_forward:
                Toast.makeText(getBaseContext(), "Forward" , Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.action_delete:
                Toast.makeText(getBaseContext(), "Delete" , Toast.LENGTH_SHORT ).show();
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
