package com.mydomain.app.week9.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mydomain.app.week9.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper{
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Employeesdb";
    public static final String TABLE_NAME = "employees";

    //column names
    public static final String COLUMN_ID = "_ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_AGE = "AGE";
    public static final String COLUMN_SALARY = "SALARY";

    public DBHelper(Context ctx){
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_NAME + "( _ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, " + "AGE INTEGER, " + "SALARY DOUBLE);");
        db.execSQL("INSERT INTO employees VALUES (NULL, 'JOqweHN DOE', 15 , 5412.00);");
        db.execSQL("INSERT INTO employees VALUES (NULL, 'JwewANE DOE', 55 , 42424.00);");
        db.execSQL("INSERT INTO employees VALUES (NULL, '123JACK DOE', 25 , 25444.00);");

        Log.d("TAG_DBHelper", "DBHelper.onCreate()");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.d("TAG_DBHelper", "DBHelper.onUpgrade()");
        db.execSQL("INSERT INTO employees VALUES (NULL, 'upJOHN DOE', 15 , 5412.00);");
        db.execSQL("INSERT INTO employees VALUES (NULL, 'upJANE DOE', 55 , 42424.00);");
        db.execSQL("INSERT INTO employees VALUES (NULL, 'upJACK DOE', 25 , 25444.00);");
    }

    public Contact getContactFromId(int contactId){
        Contact contact = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _ID, NAME, AGE, SALARY FROM EMPLOYEES WHERE _ID = " + contactId, null);
        if(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            Integer age = cursor.getInt(2);
            Double salary = cursor.getDouble(3);

            contact = new Contact(id, name, age, salary);
        }
        db.close();
        return contact;
    }

    public List<Contact> getAllContacts(){
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _ID, NAME, AGE, SALARY FROM EMPLOYEES", null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            Integer age = cursor.getInt(2);
            Double salary = cursor.getDouble(3);

            Contact c = new Contact(id, name, age, salary);
            contacts.add(c);
        }
        db.close();
        return contacts;
    }

    public List<Contact> getSearchContacts(String keyword){
        String condition = " WHERE NAME LIKE '%" + keyword + "%'";
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _ID, NAME, AGE, SALARY FROM EMPLOYEES" + condition, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            Integer age = cursor.getInt(2);
            Double salary = cursor.getDouble(3);

            Contact c = new Contact(id, name, age, salary);
            contacts.add(c);
        }
        db.close();
        return contacts;
    }

    public void deleteContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM EMPLOYEES " + "WHERE _ID = " + id);
        db.close();
    }

    public void updateContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(
                "UPDATE EMPLOYEES SET NAME = '" + contact.getName() + "', " +
                        "AGE = " + contact.getEmail() + ", " +
                        "SALARY = " + contact.getPhone() + ", " +
                        "WHERE _ID = " + contact.getId()
        );
        db.close();
    }

    public void addContact(String name, Integer age, Double salary){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(
                "INSERT INTO EMPLOYEES VALUES (" +
                        "NULL, " +
                        "'" + name + "', " +
                        "" + age + ", " +
                        "" + salary + "" +
                        ")"
        );
        db.close();
    }
}