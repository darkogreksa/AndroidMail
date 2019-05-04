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
import android.widget.Toast;

import com.example.pmsumail.adapters.MessagesListAdapter;
import com.example.pmsumail.model.Message;
import com.example.pmsumail.model.Folder;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;


public class FolderActivity extends AppCompatActivity {

    private ArrayList<Folder> folders = new ArrayList<Folder>();
    private ArrayList<Message> messages = new ArrayList<Message>();


    private MessagesListAdapter messagesListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);


        Toolbar toolbar = findViewById(R.id.folder_toolbar);
        setSupportActionBar(toolbar);


        messagesListAdapter = new MessagesListAdapter(this, UtilsDummyModels.getMockedMessages(FolderActivity.this));
        final ListView listView = findViewById(R.id.folder_list);
        listView.setAdapter(messagesListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Message messages = UtilsDummyModels.getMockedMessages(FolderActivity.this).get(i);

                Intent intent = new Intent(FolderActivity.this, EmailActivity.class);
                intent.putExtra("Content", messages.getContent());
                intent.putExtra("From", messages.getFrom().getFirstname() + " " + messages.getFrom().getLastname());

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
