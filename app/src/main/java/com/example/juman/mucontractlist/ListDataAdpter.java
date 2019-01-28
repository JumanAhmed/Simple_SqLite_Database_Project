package com.example.juman.mucontractlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Juman on 1/20/2016.
 */
public class ListDataAdpter extends ArrayAdapter {

    List list = new ArrayList();
    public ListDataAdpter(Context context, int resource) {
        super(context, resource);
    }

    class LayoutHandeler{
        TextView name,roll,address,phone,email;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view= convertView;
        LayoutHandeler layoutHandeler;

        if (view == null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.contactlistview,parent,false);
            layoutHandeler = new LayoutHandeler();

            layoutHandeler.name = (TextView) view.findViewById(R.id.tvName);
            layoutHandeler.roll= (TextView) view.findViewById(R.id.tvRoll);
            layoutHandeler.address= (TextView) view.findViewById(R.id.tvAddress);
            layoutHandeler.phone= (TextView) view.findViewById(R.id.tvPhone);
            layoutHandeler.email= (TextView) view.findViewById(R.id.tvEmail);

            view.setTag(layoutHandeler);

        }else {
            layoutHandeler = (LayoutHandeler) view.getTag();
        }

        ContactInfo contactInfo = (ContactInfo) this.getItem(position);
        layoutHandeler.name.setText(contactInfo.getName());
        layoutHandeler.roll.setText(contactInfo.getRoll());
        layoutHandeler.address.setText(contactInfo.getAddress());
        layoutHandeler.phone.setText(contactInfo.getPhone());
        layoutHandeler.email.setText(contactInfo.getEmail());



        return view;
    }
}
