package com.example.pmsumail.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmsumail.R;
import com.example.pmsumail.model.Email;

import java.util.ArrayList;

public class EmailFragment extends Fragment {
    View view;

    Email email = new Email();
    ArrayList<Email> emails = new ArrayList<>();

    public EmailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.email_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView from_view = view.findViewById(R.id.from_view);
        from_view.setText(getActivity().getIntent().getStringExtra("From"));

        TextView to_view = view.findViewById(R.id.to_view);
        to_view.setText(getActivity().getIntent().getStringExtra("To"));

        TextView subject_view = view.findViewById(R.id.subject_view);
        subject_view.setText(getActivity().getIntent().getStringExtra("Subject"));

        TextView cc_view = view.findViewById(R.id.cc_view);
        cc_view.setText(getActivity().getIntent().getStringExtra("CC"));

        TextView bc_view = view.findViewById(R.id.bc_view);
        bc_view.setText(getActivity().getIntent().getStringExtra("BC"));

        TextView content_view = view.findViewById(R.id.content_view);
        content_view.setText(getActivity().getIntent().getStringExtra("Content"));

        TextView date_messages = view.findViewById(R.id.date_messages);






    }
}
