package com.example.pmsumail.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmsumail.R;
import com.example.pmsumail.model.Email;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EmailListAdapter extends ArrayAdapter<Email> {

    private  Email email;


    public EmailListAdapter(Context context, ArrayList<Email> emails) {
        super(context, 0, emails);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        email = getItem(position);

        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.email_list_item, viewGroup, false);
        }

        TextView email_context_view = view.findViewById(R.id.email_context_view);
        TextView email_from_view = view.findViewById(R.id.email_name_view);
        TextView date_messages = view.findViewById(R.id.date_messages);
        ImageView image_view = view.findViewById(R.id.image_view);

        email_context_view.setText(email.getContent());
        email_from_view.setText(email.getFrom());

        SimpleDateFormat simpleDate =  new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDate.format(email.getDateTime());
        date_messages.setText(date);
        image_view.setImageBitmap(email.getPhoto());




        return view;
    }

}
