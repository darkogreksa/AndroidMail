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
import android.util.Log;
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
import com.example.pmsumail.model.Account;
import com.example.pmsumail.model.Folder;
import com.example.pmsumail.model.Message;
import com.example.pmsumail.model.NavItem;
import com.example.pmsumail.service.AccountService;
import com.example.pmsumail.service.FolderService;
import com.example.pmsumail.service.MessageService;
import com.example.pmsumail.service.ServiceUtils;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.pmsumail.service.ServiceUtils.messageService;

public class EmailsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private RelativeLayout mDrawerPane;
    private ListView mDrawerList;
    private AppBarLayout appBarLayout;
    private CharSequence mTitle;
    private List<Message> messages = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Folder> folders = new ArrayList<>();
    private ListView listView;
    private SharedPreferences sharedPreferences;
    private String userPref;
    private Message message = new Message();
    private boolean sortMessages;
    private MessageService messageService;
    private AccountService accountService;
    private FolderService folderService;

    private ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();

    private EmailListAdapter emailListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails);

        prepareMenu(mNavItems);

        mTitle = getTitle();
        appBarLayout = findViewById(R.id.appbar);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        mDrawerList = findViewById(R.id.navList);
        listView = findViewById(R.id.emails_list);

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
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EmailsActivity.this, CreateEmailActivity.class);
                startActivity(i);
                Toast.makeText(getBaseContext(), "Fab" , Toast.LENGTH_SHORT ).show();

            }
        });

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


        //Dodato zbog servisa
        TextView userText = findViewById(R.id.userName);
        sharedPreferences = getSharedPreferences(LoginActivity.MyPres, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(LoginActivity.Username)){
            userText.setText(sharedPreferences.getString(LoginActivity.Name, ""));
        }
        userPref = sharedPreferences.getString(LoginActivity.Username, "");

        messageService = ServiceUtils.messageService;
        accountService = ServiceUtils.accountService;
//        folderService = ServiceUtils.folderService;

        Call call = messageService.getMessages();

        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {

                if(response.isSuccessful()){
                    messages = response.body();
                    listView.setAdapter(new EmailListAdapter(EmailsActivity.this, messages));
                }
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("darko", "onFailure: " + t.getMessage());
            }
        });

        Call callAccounts = accountService.getAccounts();

        callAccounts.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> callAcc, Response<List<Account>> responseAcc) {
                if(responseAcc.isSuccessful()){
                    accounts = responseAcc.body();
                }
            }

            @Override
            public void onFailure(Call callAcc, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


//        OVO JE ZA POJEDINACAN EMAIL I PRELAZAK NA EMAIL ACTIVITY

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                message = messages.get(i);

                messageService = ServiceUtils.messageService;
                Call<Message> call = messageService.getMessage(message.getId());

                call.enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Call<Message> call, Response<Message> response) {

                        if (response.isSuccessful()){
                            message = response.body();
                            Intent intent = new Intent(EmailsActivity.this,EmailActivity.class);
                            intent.putExtra("Message", new Gson().toJson(message));

                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Message> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    }

    //Dodato zbog servisa
    public void getMessage(){
        Call<List<Message>> call = messageService.getMessages();

        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                messages = response.body();
                EmailListAdapter emailListAdapter = new EmailListAdapter(EmailsActivity.this, messages);
                listView.setAdapter(emailListAdapter);
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {

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
        mNavItems.add(new NavItem("Logout", null, R.drawable.ic_icon));
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
        }else if(position == 3) {
            Intent ite = new Intent(this, LoginActivity.class);
            sharedPreferences.edit().clear().commit();
            startActivity(ite);
            finish();
        }
        mDrawerList.setItemChecked(position, true);
        setTitle(mNavItems.get(position).getmTitle());
        mDrawerLayout.closeDrawer(mDrawerPane);
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