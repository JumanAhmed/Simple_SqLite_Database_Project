package com.example.juman.mucontractlist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SearchContactActivity extends AppCompatActivity {

    EditText searchword;
    TextView tvRoll,tvaddress,tvphone,tvemail;
    DatabasedHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);

        searchword = (EditText) findViewById(R.id.etsearch);
        tvRoll = (TextView) findViewById(R.id.dtvroll);
        tvaddress = (TextView) findViewById(R.id.dtvaddress);
        tvphone = (TextView) findViewById(R.id.dtvphone);
        tvemail = (TextView) findViewById(R.id.dtvemail);
        mydb =new DatabasedHelper(getApplicationContext());

        tvRoll.setVisibility(View.GONE);
        tvaddress.setVisibility(View.GONE);
        tvphone.setVisibility(View.GONE);
        tvemail.setVisibility(View.GONE);


    }

    public void searchword(View view)
    {
        String keyword= searchword.getText().toString();
        Cursor cursor = mydb.SearchContacts(keyword);

        if (cursor.moveToFirst()){

            String roll =cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserRoll));
            String address =cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserAddress));
            String phone =cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserPhone));
            String email =cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserEmail));

            tvRoll.setText(roll);
            tvaddress.setText(address);
            tvphone.setText(phone);
            tvemail.setText(email);

            tvRoll.setVisibility(View.VISIBLE);
            tvaddress.setVisibility(View.VISIBLE);
            tvphone.setVisibility(View.VISIBLE);
            tvemail.setVisibility(View.VISIBLE);
        }
        else{

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_contact, menu);
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
