package joker.bloodbanktest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by Joker on 25-Jan-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private  int id;
    private static final String DATABASE_NAME = "Donors_List.db";
    private static final String TABLE_NAME = "Donors_Info";

    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_MOBILE = "Mobile";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_LOCATION = "Location";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_BLOODGROUP = "BloodGroup";
    private static final String COLUMN_AGE = "Age";
    private static final String COLUMN_WEIGHT = "Weight";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_BLOODBORNEHIV = "BloodborneHIV";
    private static final String COLUMN_BLOODBORNEHp = "BloodborneHp";
    private static final String COLUMN_LASTD = "LastD";
    private static final String COLUMN_LASTM = "LastM";
    private static final String COLUMN_LASTY = "LastY";


    SQLiteDatabase sqLiteDatabase;

    //Query
    private static final String TABLE_CREATE = "create table "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMN_NAME+
            " text,"+COLUMN_MOBILE+" text,"+COLUMN_EMAIL+" text,"+COLUMN_LOCATION+" text,"+COLUMN_PASSWORD+" text,"+COLUMN_BLOODGROUP+" text,"+
            COLUMN_AGE+" text,"+COLUMN_WEIGHT+" text,"+COLUMN_LASTD+" INTEGER,"+COLUMN_LASTM+" INTEGER,"+COLUMN_LASTY+" INTEGER,"+COLUMN_BLOODBORNEHIV+" text,"+COLUMN_BLOODBORNEHp+" text);";
    public DatabaseHelper(Context context) //Constructor
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLE_CREATE); //Execute Query
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        this.onCreate(sqLiteDatabase);
    }

    public  void insertContact(Contact c)
    {
        //to insert anything in database it needs to make writeable
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,c.getdName());
        values.put(COLUMN_MOBILE,c.getdMobile());
        values.put(COLUMN_EMAIL,c.getdEmail());
        values.put(COLUMN_LOCATION,c.getdLoca());
        values.put(COLUMN_PASSWORD,c.getdPass());
        values.put(COLUMN_BLOODGROUP,c.getdBldgrp());
        values.put(COLUMN_AGE,c.getdAge());
        values.put(COLUMN_WEIGHT,c.getdWeight());
        values.put(COLUMN_LASTD,c.getdLastD());
        values.put(COLUMN_LASTM,c.getdLastM());
        values.put(COLUMN_LASTY,c.getdLastY());
        values.put(COLUMN_BLOODBORNEHIV,c.getBloodborneHiv());
        values.put(COLUMN_BLOODBORNEHp,c.getBloodborneHp());

        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();
    }

    public void updateContact(Contact c,int ID)
    {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,c.getdName());
        values.put(COLUMN_MOBILE,c.getdMobile());
        values.put(COLUMN_EMAIL,c.getdEmail());
        values.put(COLUMN_LOCATION,c.getdLoca());
        values.put(COLUMN_BLOODGROUP,c.getdBldgrp());
        values.put(COLUMN_AGE,c.getdAge());
        values.put(COLUMN_WEIGHT,c.getdWeight());
        values.put(COLUMN_LASTD,c.getdLastD());
        values.put(COLUMN_LASTM,c.getdLastM());
        values.put(COLUMN_LASTY,c.getdLastY());
        values.put(COLUMN_BLOODBORNEHIV,c.getBloodborneHiv());
        values.put(COLUMN_BLOODBORNEHp,c.getBloodborneHp());
        sqLiteDatabase.update(TABLE_NAME,values,"ID="+ID,null);
        sqLiteDatabase.close();
    }
    public boolean searchEmail(String uEmail)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT Email FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        String email;
        if(cursor.moveToFirst())
        {
            do
            {
                email = cursor.getString(cursor.getColumnIndex("Email"));
                if(email.equals(uEmail))
                {
                    return true;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return false;

    }

    public  String searchPassword(String givenEmail)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT Email, Password, ID FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        String storeEmail,storePass;
        storePass = "Not Found";
        if(cursor.moveToFirst())
        {
            do
            {
                storeEmail = cursor.getString(cursor.getColumnIndex("Email"));
                if(storeEmail.equals(givenEmail))
                {
                    storePass = cursor.getString(cursor.getColumnIndex("Password"));
                    id = cursor.getInt(cursor.getColumnIndex("ID"));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return storePass;
    }
    public int getID()
    {
        return id;
    }

    public ArrayList<String> userInfo(int givenID)
    {
        sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT ID, Name, Mobile, Email, Location, BloodGroup, Age, Weight, LastD,LastM,LastY, BloodborneHIV, BloodborneHp FROM "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        ArrayList<String>info = new ArrayList<String>();
        int storeID;
        if(cursor.moveToFirst())
        {
            do
            {
                storeID = cursor.getInt(cursor.getColumnIndex("ID"));
                if(storeID==givenID)
                {
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_MOBILE)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_LOCATION)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_BLOODGROUP)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_AGE)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_WEIGHT)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_LASTD)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_LASTM)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_LASTY)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_BLOODBORNEHIV)));
                    info.add(cursor.getString(cursor.getColumnIndex(COLUMN_BLOODBORNEHp)));
                    break;
                }
            }while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return info;
    }

    public List<DonorDetails> getDonorList() {
        DonorDetails donorDetails = null;
        List<DonorDetails> donorD = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Donors_Info", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            donorDetails = new DonorDetails(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)
                    ,cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getInt(9),cursor.getInt(10),cursor.getInt(11));

            donorD.add(donorDetails);
            cursor.moveToNext();
        }
        cursor.close();
        return donorD;
    }
    public List<DonorDetails> getSearchedDonorList(String group,String location) {
        DonorDetails donorDetails = null;
        List<DonorDetails> donorD = new ArrayList<>();
        sqLiteDatabase = this.getReadableDatabase();
        Calendar calendar;
        int year, month,day;
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);


        String uGroup = group;

        String uLoc = location.toUpperCase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Donors_Info", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            String sGroup =  cursor.getString(6);
            String sLocation = cursor.getString(4).toUpperCase();
            String h1= cursor.getString(12);
            String h2 = cursor.getString(13);

            int oDay =  cursor.getInt(9);
            int oMon = cursor.getInt(10);
            int oYear = cursor.getInt(11);

            if(oDay > day)
            {
                month = month - 1;
                day = day + 30;
            }
            if(oMon > month)
            {
                year = year - 1;
                month = month + 12;
            }
            int cday = day - oDay;
            int cmonth = month - oMon;
            int cyear = year - oYear;

            int tday = (cyear*365 + cmonth*30 + cday);






            if(uGroup.equals(sGroup) && uLoc.equals(sLocation) && tday>90 && h1.equals("No") && h2.equals("No") ) {
                donorDetails = new DonorDetails(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)
                        , cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getInt(9),cursor.getInt(10),cursor.getInt(11));

                donorD.add(donorDetails);
            }
            cursor.moveToNext();
        }
        cursor.close();
        return donorD;
    }
}
