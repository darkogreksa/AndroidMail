package com.example.pmsumail;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.example.pmsumail.adapters.FolderListAdapter;
import com.example.pmsumail.model.Folder;
import com.example.pmsumail.model.NavItem;
import com.example.pmsumail.service.FolderService;
import com.example.pmsumail.service.ServiceUtils;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.pmsumail.service.ServiceUtils.folderService;
import static com.example.pmsumail.service.ServiceUtils.messageService;

public class FoldersActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private RelativeLayout mDrawerPane;
    private ListView mDrawerList;
    private AppBarLayout appBarLayout;
    private CharSequence mTitle;
    private ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    private List<Folder> folders = new ArrayList<>();
    private Folder folder = new Folder();
    private SharedPreferences sharedPreferences;
    private FolderService folderService;
    private ListView listView;

    private FolderListAdapter folderListAdapter;


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
                Intent in = new Intent (FoldersActivity.this, CreateFolderActivity.class);
                startActivity(in);
                Toast.makeText(getBaseContext(), "Fab" , Toast.LENGTH_SHORT ).show();;

            }
        });

//        //dodajes listu itema u adapter
//        folderListAdapter = new FolderListAdapter(this, UtilsDummyModels.getMockedFolders(FoldersActivity.this));
//        final ListView listView = findViewById(R.id.folders_list);
//        listView.setAdapter(folderListAdapter);
////        setujes na klik listenre
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
////                int i ti je index kliknut u nizu
//                Folder folder = UtilsDummyModels.getMockedFolders(FoldersActivity.this).get(i);
//
//                Intent intent = new Intent(FoldersActivity.this, FolderActivity.class);
//                intent.putExtra("Folder_name", folder.getName());
//
//                try {
//                    String fileName = "drawable";
//
//
//                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//
//
//                    FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
//
//
//                    fileOutputStream.write(bytes.toByteArray());
//                    fileOutputStream.close();
//
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                startActivity(intent);
//            }
//        });

        folderService = ServiceUtils.folderService;

        Call call = folderService.getFolders();

        call.enqueue(new Callback<List<Folder>>() {
            @Override
            public void onResponse(Call<List<Folder>> call, Response<List<Folder>> response) {

                if(response.isSuccessful()){
                    folders = response.body();
                    listView.setAdapter(new FolderListAdapter(FoldersActivity.this, folders));
                }
            }

            @Override
            public void onFailure(Call<List<Folder>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                folder = folders.get(i);

                folderService = ServiceUtils.folderService;
                Call<Folder> call = folderService.getFolder(folder.getId());

                call.enqueue(new Callback<Folder>() {
                    @Override
                    public void onResponse(Call<Folder> call, Response<Folder> response) {

                        if (response.isSuccessful()){
                            folder = response.body();
                            Intent intent = new Intent(FoldersActivity.this,FolderActivity.class);
                            intent.putExtra("Folder", new Gson().toJson(folder));

                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Folder> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }



    //Dodato zbog servisa
    public void getFolder(){
        Call<List<Folder>> call = folderService.getFolders();

        call.enqueue(new Callback<List<Folder>>() {
            @Override
            public void onResponse(Call<List<Folder>> call, Response<List<Folder>> response) {
                folders = response.body();
                FolderListAdapter folderListAdapter = new FolderListAdapter(FoldersActivity.this, folders);
                listView.setAdapter(folderListAdapter);
            }

            @Override
            public void onFailure(Call<List<Folder>> call, Throwable t) {

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
                Intent in = new Intent(this, CreateFolderActivity.class);
                Toast.makeText(getBaseContext(), "Create folder" , Toast.LENGTH_SHORT ).show();
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
