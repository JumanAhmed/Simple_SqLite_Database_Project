package com.example.juman.mucontractlist;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText etOldName,etnewName,etnewRoll,etnewAddress,etnewPhone,etnewEmail;
    Button btnupdated;
    DatabasedHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etOldName = (EditText) findViewById(R.id.uetoldName);
        etnewName = (EditText) findViewById(R.id.uetnewName);
        etnewRoll = (EditText) findViewById(R.id.uetnewROll);
        etnewAddress = (EditText) findViewById(R.id.uetnewAddress);
        etnewPhone = (EditText) findViewById(R.id.uetnewPhone);
        etnewEmail = (EditText) findViewById(R.id.uetnewEmail);
        btnupdated = (Button) findViewById(R.id.btnUpdated);

        etnewName.setVisibility(View.GONE);
        etnewRoll.setVisibility(View.GONE);
        etnewAddress.setVisibility(View.GONE);
        etnewPhone.setVisibility(View.GONE);
        etnewEmail.setVisibility(View.GONE);
        btnupdated.setVisibility(View.GONE);


        mydb =new DatabasedHelper(this);
    }


    public  void updateSearch(View view){
        String old_name = etOldName.getText().toString();
        Cursor cursor = mydb.SearchContacts(old_name);

        if (cursor.moveToFirst())
        {
            String name,roll,address,phone,email;
            name = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserName));
            roll =cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserRoll));
            address = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserAddress));
            phone =cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserPhone));
            email = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserEmail));


            etnewName.setText(name);
            etnewRoll.setText(roll);
            etnewAddress.setText(address);
            etnewPhone.setText(phone);
            etnewEmail.setText(email);

            etnewName.setVisibility(View.VISIBLE);
            etnewRoll.setVisibility(View.VISIBLE);
            etnewAddress.setVisibility(View.VISIBLE);
            etnewPhone.setVisibility(View.VISIBLE);
            etnewEmail.setVisibility(View.VISIBLE);
            btnupdated.setVisibility(View.VISIBLE);
        }



    }

    public void  updated(View view)
    {
        String old_name, newname,newroll,newaddress,newphone,newemail;
        old_name =etOldName.getText().toString();
        newname = etnewName.getText().toString();
        newroll = etnewRoll.getText().toString();
        newaddress =etnewAddress.getText().toString();
        newphone = etnewPhone.getText().toString();
        newemail = etnewEmail.getText().toString();

       int updated=  mydb.ContactsUpdated(old_name,newname,newroll,newaddress,newphone,newemail);
        if (updated > 0)
        {
            Toast.makeText(getApplicationContext(), updated+" row(s) updated", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getApplicationContext(),"No data updated", Toast.LENGTH_SHORT).show();
        }
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update, menu);
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
