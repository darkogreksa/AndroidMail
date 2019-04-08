package com.example.pmsumail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.example.pmsumail.adapters.ContactListAdapter;
import com.example.pmsumail.adapters.DrawerListAdapter;
import com.example.pmsumail.model.Contact;
import com.example.pmsumail.model.NavItem;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private RelativeLayout mDrawerPane;
    private ListView mDrawerList;
    private AppBarLayout appBarLayout;
    private CharSequence mTitle;
    private ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    private ContactListAdapter contactListAdapter;

    private Contact contact1 = new Contact();
    private Contact contact2 = new Contact();
    private Contact contact3 = new Contact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        prepareMenu(mNavItems);

        mTitle = getTitle();
        appBarLayout = findViewById(R.id.appbar);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        mDrawerList = findViewById(R.id.navList);

        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContactsActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

        mDrawerPane = findViewById(R.id.drawerPane);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setOnItemClickListener(new ContactsActivity.DrawerItemClickListener());
        mDrawerList.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.contacts_toolbar);
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
                Snackbar.make(findViewById(R.id.coordinator),"Fab",Snackbar.LENGTH_SHORT).show();
            }
        });

        contact1.setFirstname("Paul");
        contact1.setLastname("Kalkbrenner");
        contact1.setEmail("paulkalkbrenner@gmail.com");
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.paul);
        contact1.setPhoto(bitmap);

        contact2.setFirstname("Amelie");
        contact2.setLastname("Lens");
        contact2.setEmail("amelielens@yahoo.com");
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.amelie);
        contact2.setPhoto(bitmap1);

        contact3.setFirstname("Carl");
        contact3.setLastname("Cox");
        contact3.setEmail("carlcox@gmail.com");
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.carl);
        contact3.setPhoto(bitmap2);

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        contactListAdapter = new ContactListAdapter(this, contacts);
        final ListView listView = findViewById(R.id.contacts_list);
        listView.setAdapter(contactListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Contact contact = contacts.get(i);

                Intent intent = new Intent(ContactsActivity.this, ContactActivity.class);
                intent.putExtra("First name", contact.getFirstname());
                intent.putExtra("Last name", contact.getLastname());
                intent.putExtra("Email", contact.getEmail());

                try {
                    String fileName = "drawable";
                    Bitmap mBitmap = contact.getPhoto();

                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    mBitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes);

                    FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);

                    fileOutputStream.write(bytes.toByteArray());
                    fileOutputStream.close();

                    intent.putExtra("photo",fileName);

                }catch (Exception e){
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });

    }

    private void prepareMenu(ArrayList<NavItem> mNavItems ){
        mNavItems.add(new NavItem(getString(R.string.emails), null, R.drawable.ic_emails));
        mNavItems.add(new NavItem(getString(R.string.folders), null, R.drawable.ic_folders));
        mNavItems.add(new NavItem(getString(R.string.settings), null, R.drawable.ic_settings));
    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItemFromDrawer(position);
        }
    }


    private void selectItemFromDrawer(int position){
        if(position == 0){
            Intent emailsIntent = new Intent(this, EmailsActivity.class);
            startActivity(emailsIntent);
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

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_item_contacts, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_contacts:
                Intent in = new Intent(this, CreateContactActivity.class);
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
