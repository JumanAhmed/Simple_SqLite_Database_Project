package com.example.juman.mucontractlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public  void add(View view)

    {
        Intent intent=new Intent(getApplicationContext(), AddContactActivity.class);
        startActivity(intent);
    }

    public  void show(View view)
    {
        Intent intent= new Intent(getApplicationContext(), ViewContactActivity.class);
        startActivity(intent);
    }

    public  void search(View view)
    {
        Intent intent=new Intent(getApplicationContext(), SearchContactActivity.class);
        startActivity(intent);

    }

    public  void update(View view)
    {
        Intent intent = new Intent(getApplicationContext(), UpdateActivity.class);
        startActivity(intent);

    }

    public  void delete(View view)
    {
        Intent intent = new Intent(getApplicationContext(), DeleteContactActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
