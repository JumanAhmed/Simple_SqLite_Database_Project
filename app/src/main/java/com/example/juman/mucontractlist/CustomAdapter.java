package com.example.juman.mucontractlist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juman on 1/17/2016.
 */
public class CustomAdapter extends ArrayAdapter {
   Activity activity;
    ArrayList<ContactInfo> contactInfos;

    public CustomAdapter(Context context, ArrayList<ContactInfo> contacts) {
        super(context, R.layout.contactlistview, contacts);

        this.activity=(Activity)context;
        this.contactInfos=contacts;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null)
        {
            // Generate a View and return
            LayoutInflater inflater=activity.getLayoutInflater();
            v= inflater.inflate(R.layout.contactlistview,null);

            TextView txtName= (TextView) v.findViewById(R.id.tvName);
            TextView txtRoll= (TextView) v.findViewById(R.id.tvRoll);
            TextView txtPhone= (TextView) v.findViewById(R.id.tvPhone);
            TextView txtEmail= (TextView) v.findViewById(R.id.tvEmail);
            TextView txtAddress = (TextView) v.findViewById(R.id.tvAddress);

            ContactInfo c = contactInfos.get(position);

            txtName.setText(c.getName());
            txtRoll.setText(c.getRoll());
            txtPhone.setText(c.getPhone());
            txtEmail.setText(c.getEmail());
            txtAddress.setText(c.getAddress());


        }else {
            v=convertView;
        }



        return v;
    }
}
