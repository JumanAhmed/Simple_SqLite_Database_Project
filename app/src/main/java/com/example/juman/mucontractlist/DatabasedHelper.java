package com.example.juman.mucontractlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Juman on 1/16/2016.
 */
public class DatabasedHelper extends SQLiteOpenHelper {

    private  static final String DataBaseName = "mufriendsdb";
    private  static final int DB_Version = 1;

    public static final String Contact_Table_SQL = "CREATE TABLE "+ ContactTableInfo.Newinfo.TableName + " ( "
            + ContactTableInfo.Newinfo.UserName + " TEXT, " + ContactTableInfo.Newinfo.UserRoll + " TEXT, "
            + ContactTableInfo.Newinfo.UserAddress + " TEXT, " + ContactTableInfo.Newinfo.UserPhone + " TEXT, "
            + ContactTableInfo.Newinfo.UserEmail + " TEXT)";



    public DatabasedHelper(Context context) {
        super(context, DataBaseName, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(Contact_Table_SQL);
        Log.e("Table Create", Contact_Table_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS " + Contact_Table_SQL); // Drop Older Table if exists

        onCreate(db);

    }


    // Insert Data Into DataBased
    public long insertContact(String name,String roll, String address, String phone, String email){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(ContactTableInfo.Newinfo.UserName, name);
        values.put(ContactTableInfo.Newinfo.UserRoll, roll);
        values.put(ContactTableInfo.Newinfo.UserAddress, address);
        values.put(ContactTableInfo.Newinfo.UserPhone, phone);
        values.put(ContactTableInfo.Newinfo.UserEmail, email);

        long inserted=db.insert(ContactTableInfo.Newinfo.TableName, null,values);
        db.close();

        return inserted;
    }


    // Quary

    public Cursor getInformation()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.query(ContactTableInfo.Newinfo.TableName,null,null,null,null,null,null);

        return cursor;
    }


    // keywoud quary

    public Cursor SearchContacts(String keyword)
    {
        Cursor cursor;
        String[] projections ={ContactTableInfo.Newinfo.UserName,ContactTableInfo.Newinfo.UserRoll, ContactTableInfo.Newinfo.UserAddress,
                ContactTableInfo.Newinfo.UserPhone, ContactTableInfo.Newinfo.UserEmail};
        String selection = ContactTableInfo.Newinfo.UserName+ " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db=this.getReadableDatabase();

        cursor =db.query(ContactTableInfo.Newinfo.TableName,projections,selection,selection_args,null,null,null);
        // if i am not include "name" column in the projection then the cursor not going to this columN and i can't retrive the data from the columm
         return cursor;
    }


    // Delete row

    public  int DeleteContact(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String selection = ContactTableInfo.Newinfo.UserName+ " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(ContactTableInfo.Newinfo.TableName, selection, seletion_args);

        return deleted;
    }

    // Update contacts

    public  int  ContactsUpdated(String old_name,String name,String roll, String address, String phone, String email)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values =new ContentValues();

        String selection = ContactTableInfo.Newinfo.UserName + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(ContactTableInfo.Newinfo.UserName, name);
        values.put(ContactTableInfo.Newinfo.UserRoll, roll);
        values.put(ContactTableInfo.Newinfo.UserAddress, address);
        values.put(ContactTableInfo.Newinfo.UserPhone, phone);
        values.put(ContactTableInfo.Newinfo.UserEmail, email);


        int updated =db.update(ContactTableInfo.Newinfo.TableName,values,selection, selection_args);

        return updated;
    }

    // Store information Quary

//    public ArrayList<ContactInfo> getAllContacts(){
//        ArrayList<ContactInfo> allcontacts=new ArrayList<ContactInfo>();
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor cursor= db.query(ContactTableInfo.Newinfo.TableName, null, null, null, null, null, null); // select * from contactifo
//
//        if (cursor != null && cursor.getCount() >0 )
//        {
//            cursor.moveToFirst();
//            for (int i=0; i< cursor.getCount(); i++)
//            {
//
//                String name = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserName));   // //getInt(); get value from index
//                String roll = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserRoll));
//                String address = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserAddress));
//                String phone = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserPhone));
//                String email = cursor.getString(cursor.getColumnIndex(ContactTableInfo.Newinfo.UserEmail));
//
//                ContactInfo contactInfo=new ContactInfo(name,roll,address,phone,email);
//                allcontacts.add(contactInfo);
//
//                cursor.moveToNext();
//            }
//        }
//        cursor.close();
//        db.close();
//
//        return  allcontacts;
//    }


}
