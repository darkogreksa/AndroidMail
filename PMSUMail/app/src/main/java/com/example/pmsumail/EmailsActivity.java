package com.example.pmsumail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmsumail.adapters.DrawerListAdapter;
import com.example.pmsumail.adapters.EmailListAdapter;
import com.example.pmsumail.model.Email;
import com.example.pmsumail.model.NavItem;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class EmailsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private RelativeLayout mDrawerPane;
    private ListView mDrawerList;
    private AppBarLayout appBarLayout;
    private CharSequence mTitle;
    private ArrayList<Email> emails = new ArrayList<Email>();
    private ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();

    private EmailListAdapter emailListAdapter;

    private Email email1 = new Email();
    private Email email2 = new Email();
    private Email email3  = new Email();
    private Email email4 = new Email();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails);

        prepareMenu(mNavItems);

        mTitle = getTitle();
        appBarLayout = findViewById(R.id.appbar);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        mDrawerList = findViewById(R.id.navList);

        //Prelazak na ProfileActivity na klik na "view profile"
        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EmailsActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

        mDrawerPane = findViewById(R.id.drawerPane);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerList.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.emails_toolbar);
        setSupportActionBar(toolbar);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
            actionBar.setHomeButtonEnabled(true);
        }

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Fab" , Toast.LENGTH_SHORT ).show();
            }
        });

        email1.setFrom("Amelie");
        email1.setContent(":Message...");
        email1.setDateTime(new Date());

        email2.setContent(":Message...");
        email2.setFrom("Carl");
        email2.setDateTime(new Date());

        email3.setContent(":Message...");
        email3.setFrom("Kole");
        email3.setDateTime(new Date());


        emails.add(email1);
        emails.add(email2);
        emails.add(email3);


        emailListAdapter = new EmailListAdapter(this, emails);
        final ListView listView = findViewById(R.id.emails_list);
        listView.setAdapter(emailListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Email email = emails.get(i);

                Intent intent = new Intent(EmailsActivity.this, EmailActivity.class);
                intent.putExtra("Content", email.getContent());
                intent.putExtra("From", email.getFrom());

                try {
                    String fileName = "drawable";


                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();


                    FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);


                    fileOutputStream.write(bytes.toByteArray());
                    fileOutputStream.close();


                }catch (Exception e){
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });

    }

    //listener koji prihvata informaciju koja pozicija u draweru je kliknuta
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItemFromDrawer(position);
        }
    }

    //ikonice i tekst za navigation drawer
    private void prepareMenu(ArrayList<NavItem> mNavItems ){
        mNavItems.add(new NavItem(getString(R.string.contacts), null, R.drawable.ic_contact));
        mNavItems.add(new NavItem(getString(R.string.folders), null, R.drawable.ic_folders));
        mNavItems.add(new NavItem(getString(R.string.settings), null, R.drawable.ic_settings));
    }

    //prelazak na aktivnosti iz navigation drawera
    private void selectItemFromDrawer(int position){
        if(position == 0){
            Intent contactsIntent = new Intent(this, ContactsActivity.class);
            startActivity(contactsIntent);
        }else if(position == 1){
            Intent foldersIntent = new Intent(this,FoldersActivity.class);
            startActivity(foldersIntent);
        }else if(position == 2){
            Intent settingsIntent = new Intent(this,SettingsActivity.class);
            startActivity(settingsIntent);
        }
        mDrawerList.setItemChecked(position, true);
        setTitle(mNavItems.get(position).getmTitle());
        mDrawerLayout.closeDrawer(mDrawerPane);
    }

    //tekst koji se ispisuje na toolbar-u
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    //meni na toolbaru, odnosno ikonice za prelazak na ostale aktivnosti
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_item_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //funkcionalnost opcija iz menija gore navedenog
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(this, SettingsActivity.class);
                Toast.makeText(getBaseContext(), "Settings" , Toast.LENGTH_SHORT ).show();
                startActivity(i);
                return true;
            case R.id.action_create_email:
                Intent in = new Intent(this, CreateEmailActivity.class);
                Toast.makeText(getBaseContext(), "Create mail" , Toast.LENGTH_SHORT ).show();
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
