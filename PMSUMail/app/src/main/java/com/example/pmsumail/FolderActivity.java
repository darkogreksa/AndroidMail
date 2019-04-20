package com.example.pmsumail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.pmsumail.adapters.EmailListAdapter;
import com.example.pmsumail.model.Email;
import com.example.pmsumail.model.Folder;

import java.util.ArrayList;


public class FolderActivity extends AppCompatActivity {

    private ArrayList<Folder> folders = new ArrayList<Folder>();
    private ArrayList<Email> emails = new ArrayList<Email>();
    private EmailListAdapter emailListAdapter;



    private Folder folder1 = new Folder();
    private Folder folder2 = new Folder();
    private Folder folder3 = new Folder();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);


        Toolbar toolbar = findViewById(R.id.folder_toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_item_folder, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.edit_folder:
                Toast.makeText(getBaseContext(), "Edit folder" , Toast.LENGTH_SHORT ).show();
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
