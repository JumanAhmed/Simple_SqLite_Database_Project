package com.example.juman.mucontractlist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewContactActivity extends AppCompatActivity {

    ListView listView;
    DatabasedHelper mydb;
    Cursor cursor;
    ListDataAdpter listDataAdpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);

        listView=(ListView)findViewById(R.id.listView);

        TextView emptyText = (TextView)findViewById(android.R.id.empty);
        listView.setEmptyView(emptyText);

        mydb=new DatabasedHelper(this);
        cursor= mydb.getInformation();
        listDataAdpter= new ListDataAdpter(getApplicationContext(),R.layout.contactlistview);
        listView.setAdapter(listDataAdpter);

        if (cursor.moveToFirst())
        {
            do {
                String name, roll, address, phone, email;

                name=cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserName));
                roll = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserRoll));
                address = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserAddress));
                phone = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserPhone));
                email = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserEmail));
                ContactInfo contactInfo =new ContactInfo(name,roll,address,phone,email);
                listDataAdpter.add(contactInfo);

            }while (cursor.moveToNext());
            {

            }

        }




//        if (contacts != null && contacts.size() > 0)
//        {
//
//            CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(), contacts);
//
//            listView.setAdapter(customAdapter);
//        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
