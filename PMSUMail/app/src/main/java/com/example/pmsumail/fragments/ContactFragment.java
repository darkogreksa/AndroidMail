package com.example.pmsumail.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmsumail.R;
import com.example.pmsumail.model.Contact;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ContactFragment extends Fragment {

    View view;

    private Contact contact;
    ArrayList<Contact> contacts = new ArrayList<>();

    public ContactFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.contact_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String json = null;
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null){
            json = extras.getString("Contact");
        }
        contact = new Gson().fromJson(json, Contact.class);

        contact.getId();

        TextView firstname_view = view.findViewById(R.id.firstname_view);
        firstname_view.setText(contact.getFirstname());

        TextView lastname_view = view.findViewById(R.id.lastname_view);
        lastname_view.setText(contact.getLastname());

        TextView email_view = view.findViewById(R.id.email_view);
        email_view.setText(contact.getEmail());
    }
}
