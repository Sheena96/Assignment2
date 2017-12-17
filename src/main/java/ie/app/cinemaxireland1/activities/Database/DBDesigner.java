package ie.app.cinemaxireland1.activities.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.util.Log;

/**
 * Created by sheenakelly on 05/12/2017.
 */


public class DBDesigner extends SQLiteOpenHelper {

    private static final String TAG = "DBDesigner";

    //private static final String DATABSE_NAME = "bookings.db";
    private static final int    DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "cinema_bookings";
    private static final String COL1 = "ID";
    private static final String COL2 = "date";
    private static final String COL3 = "amount";
    private static final String COL4 = "method";
    private static final String COL5 = "name";

    /* table and column name*/

    public DBDesigner(Context context) {

        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    /* creating table and naming it "cinema_bookings" as it will store all info about bookings*/
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +COL1 + "INTEGER PRIMARY KEY, " +
                COL2 +" TEXT " + COL3 +" TEXT " + COL4 +" TEXT " + COL5 + " TEXT );";
        db.execSQL(createTable);
    }

    /* Dropping the Table if the schema is changed*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBDesigner.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destory all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /* Adding data to the database*/
    public boolean addData(String date, int amount, String method, String name) {
        /*trying to store the date selected by the user in the correct format - cannot resolve error
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //String formattedDate = formatter.format(provider.getDate());*/
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL2, showDate.getText().toString());
        contentValues.put(COL3, amount);
        contentValues.put(COL4, method);
        contentValues.put(COL5, name);

        Log.d(TAG, "addData: Adding " + date + amount + method + name +" to " + TABLE_NAME);

        // creating a long variable to determine if the data was entered correctly or incorrectly
        long result = db.insert(TABLE_NAME, null, contentValues);

        // if data was instered incorrectly it will return -1
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }

    }

    //Returns all of the data from the Database
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /* Return the ID that matches the name that user entered while making their booking */
    public Cursor getItemID(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL5 + " = ' " + name + " ' ";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /*UPDATING/EDITING THE DATA:
        I tried using these methods to update the different fields but had difficulty implementing
        them in the editBooking class:*/
        public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " UPDATE " + TABLE_NAME + " SET " + COL5 +
                " = ' " + newName + " ' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL5 + " = '" + oldName;
        Log.d(TAG, "updateName: query: " + query); //logging the query and displaying the new name in the log
        Log.d(TAG, "updateName: Setting name to " + newName);
            db.execSQL(query);
    }
    /* Update the date field*/
    public void updateDate(String newDate, int id, String oldDate){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = ' " + newDate + " ' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldDate;
        Log.d(TAG, "updateName: query: " + query); //logging the query and displaying the new date in the log
        Log.d(TAG, "updateName: Setting name to " + newDate);
        db.execSQL(query);
    }
    /* Update the amount field*/
    public void updateAmount(String newAmount, int id, String oldAmount){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " UPDATE " + TABLE_NAME + " SET " + COL3 +
                " = ' " + newAmount + " ' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL3 + " = '" + oldAmount;
        Log.d(TAG, "updateName: query: " + query); //logging the query and displaying the new amount in the log
        Log.d(TAG, "updateName: Setting name to " + newAmount);
        db.execSQL(query);
    }
    /* Update the method field*/
    public void updateMethod(String newMethod, int id, String oldMethod){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " UPDATE " + TABLE_NAME + " SET " + COL4 +
                " = ' " + newMethod + " ' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL4 + " = '" + oldMethod;
        Log.d(TAG, "updateName: query: " + query); //logging the query and displaying the new payment method in the log
        Log.d(TAG, "updateName: Setting name to " + newMethod);
        db.execSQL(query);
    }

    /* Deleting all the data from the database and logging the query*/
    public void deleteData(int id, String date, int amount, String method, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = ' " + id + " ' " +
                " AND " + COL2 + " = ' " + date + " ' " +
                " AND " + COL3 + " = ' " + amount + " ' " +
                " AND " + COL4 + " = ' " + method + " ' " +
                " AND " + COL5 + " = ' " + name   + " ' ";
        Log.d(TAG, "deletData: query: " + query);
        Log.d(TAG, "deleteData: Deleting " + date + amount + method + name + "from database.");
        db.execSQL(query);

    }



}
