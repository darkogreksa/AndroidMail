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

import java.util.ArrayList;

public class ContactFragment extends Fragment {

    View view;

    Contact contact = new Contact();
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

        TextView firstname_view = view.findViewById(R.id.firstname_view);
        firstname_view.setText(getActivity().getIntent().getStringExtra("Firstname"));

        TextView lastname_view = view.findViewById(R.id.lastname_view);
        lastname_view.setText(getActivity().getIntent().getStringExtra("Lastname"));

        TextView email_view = view.findViewById(R.id.email_view);
        email_view.setText(getActivity().getIntent().getStringExtra("name@gmail.com"));
    }
}
