package com.example.pmsumail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmsumail.adapters.MessagesListAdapter;
import com.example.pmsumail.model.Message;
import com.example.pmsumail.model.Folder;
import com.example.pmsumail.service.FolderService;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FolderActivity extends AppCompatActivity {

    private FolderService folderService;
    private Folder folder = new Folder();

    private ArrayList<Folder> folders = new ArrayList<Folder>();
    private ArrayList<Message> messages = new ArrayList<Message>();


    private MessagesListAdapter messagesListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);


        Toolbar toolbar = findViewById(R.id.folder_toolbar);
        setSupportActionBar(toolbar);

        TextView FolderName_view = findViewById(R.id.folder_title_view);

        FolderName_view.setText("Folder name: " + folder.getName());
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
            case R.id.delete_folder:
                deleteFolder();
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, FoldersActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void deleteFolder() {
        Call<Folder> call = folderService.deleteFolder(folder.getId());

        call.enqueue(new Callback<Folder>() {
            @Override
            public void onResponse(Call<Folder> call, Response<Folder> response) {

            }

            @Override
            public void onFailure(Call<Folder> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
