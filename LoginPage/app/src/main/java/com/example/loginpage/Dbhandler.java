package com.example.loginpage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;

class Dbhandler extends SQLiteOpenHelper {

    public static final int DB_version = 1;
    private static  final String Db_name = "users",Table_name ="user",User_id = "id",User_name = "name",User_password = "password";
    public Dbhandler(MainActivity context) {
        super(context,Db_name,null,DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + Table_name + " (" +
                User_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                User_name + " TEXT, " +
                User_password + " TEXT)";
        db.execSQL(createTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("Drop Table if Exists " + Table_name);
        onCreate(db);

    }
    public void addUser(User usr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(User_name,usr.getName());
        cv.put(User_password,usr.getPassword());
        db.insert(Table_name,null,cv);
        db.close();
    }

    public int checkuser(User user) {
        int id = -1;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select id from user where name =? and password=? ",new  String[] {
                user.getName(),user.getPassword()
        });
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            id = cursor.getInt(0);
            cursor.close();
        }
        return id;
    }
}
