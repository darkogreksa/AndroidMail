package com.example.pmsumail.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmsumail.R;
import com.example.pmsumail.model.Folder;
import com.example.pmsumail.service.FolderService;
import com.google.gson.Gson;

import java.util.ArrayList;

public class FolderFragment extends Fragment {
    View view;

    private Folder folder;
    ArrayList<Folder> folders = new ArrayList<>();
    private FolderService folderService;



    public FolderFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.folder_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String json = null;
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null){
            json = extras.getString("Folder");
        }
        folder = new Gson().fromJson(json, Folder.class);

        folder.getId();

        TextView FolderName_view = view.findViewById(R.id.folder_title_view);
        FolderName_view.setText(folder.getName());


    }
}