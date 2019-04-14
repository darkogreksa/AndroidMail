package com.example.pmsumail;

import android.content.Context;
import android.content.Intent;
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

import com.example.pmsumail.adapters.DrawerListAdapter;
import com.example.pmsumail.adapters.FolderListAdapter;
import com.example.pmsumail.model.Folder;
import com.example.pmsumail.model.NavItem;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class FoldersActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private RelativeLayout mDrawerPane;
    private ListView mDrawerList;
    private AppBarLayout appBarLayout;
    private CharSequence mTitle;
    private ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    private ArrayList<Folder> folders = new ArrayList<Folder>();

    private FolderListAdapter folderListAdapter;

    private Folder folder1 = new Folder();
    private Folder folder2 = new Folder();
    private Folder folder3 = new Folder();
    private Folder folder4 = new Folder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folders);

        prepareMenu(mNavItems);

        mTitle = getTitle();
        appBarLayout = findViewById(R.id.appbar);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        mDrawerList = findViewById(R.id.navList);

        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoldersActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

        mDrawerPane = findViewById(R.id.drawerPane);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);
        mDrawerList.setOnItemClickListener(new FoldersActivity.DrawerItemClickListener());
        mDrawerList.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.folders_toolbar);
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


        folder1.setName("Folder1");
        folder1.setMessages("10");

        folder2.setName("Folder2");
        folder2.setMessages("CC");

        folder3.setName("Folder3");
        folder3.setMessages("BB");

        folder4.setName("Folder4");
        folder4.setMessages("AA");

        folders.add(folder1);
        folders.add(folder2);
        folders.add(folder3);
        folders.add(folder4);

        //dodajes listu itema u adapter
        folderListAdapter = new FolderListAdapter(this, folders);
        final ListView listView = findViewById(R.id.folders_list);
        listView.setAdapter(folderListAdapter);
//        setujes na klik listenre
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
//                int i ti je index kliknut u nizu
                Folder folder = folders.get(i);

                Intent intent = new Intent(FoldersActivity.this, FolderActivity.class);
                intent.putExtra("Folder_name", folder.getName());
                intent.putExtra("Messages", folder.getMessages());

                try {
                    String fileName = "drawable";

                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();

                    FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);

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
        mNavItems.add(new NavItem(getString(R.string.contacts), null, R.drawable.ic_contact));
        mNavItems.add(new NavItem(getString(R.string.emails), null, R.drawable.ic_emails));
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
            Intent contactsIntent = new Intent(this, ContactsActivity.class);
            startActivity(contactsIntent);
        }else if(position == 1){
            Intent foldersIntent = new Intent(this,EmailsActivity.class);
            startActivity(foldersIntent);
        }
        else if(position == 2){
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
        inflater.inflate(R.menu.activity_item_folders, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_folder:
                Intent in = new Intent(this, CreateEmailActivity.class);
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
