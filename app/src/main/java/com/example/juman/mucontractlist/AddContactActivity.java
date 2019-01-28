package com.example.juman.mucontractlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {

    EditText etName,etRoll,etAddress,etPhone,etEmail;
    DatabasedHelper Db_Helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        etName= (EditText) findViewById(R.id.etName);
        etRoll= (EditText)findViewById(R.id.etRoll);
        etAddress= (EditText)findViewById(R.id.etAddress);
        etPhone= (EditText)findViewById(R.id.etPhone);
        etEmail= (EditText)findViewById(R.id.etEmail);
        Db_Helper =new DatabasedHelper(this);

    }

    public  void save(View v)
    {
        String Name=etName.getText().toString();
        String Roll=etRoll.getText().toString();
        String Address=etAddress.getText().toString();
        String Phone= etPhone.getText().toString();
        String Email=etEmail.getText().toString();

        long inserted= Db_Helper.insertContact(Name,Roll,Address,Phone,Email);

        Toast.makeText(getApplicationContext(), "Name = " +Name+ "\nRoll= " +Roll+ "\nAddress= "+ Address+
                "\nPhone= " +Phone+ "\nEmail= "+Email, Toast.LENGTH_LONG).show();
        if (inserted>=0)
        {
            Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"Data Insertion Failed......", Toast.LENGTH_LONG).show();
        }

    }

    public void clear(View view)
    {
        etName.getText().clear();
        etRoll.getText().clear();
        etAddress.getText().clear();
        etPhone.getText().clear();
        etEmail.getText().clear();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_contact, menu);
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
