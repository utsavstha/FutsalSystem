package Utils;

/**
 * Created by utsav on 8/25/2015.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "futsalBook.db";
    public static final String FUTSAL_TABLE_NAME = "futsalList";
    public static final String FUTSAL_COLUMN_ID = "id";
    public static final String FUTSAL_COLUMN_NAME = "name";
    public static final String FUTSAL_COLUMN_Address = "address";
    public static final String FUTSAL_COLUMN_DESCRIPTION = "description";
    public static final String FUTSAL_COLUMN_LONGITUDE = "longitude";
    public static final String FUTSAL_COLUMN_LATITUDE = "latitude";
    public static final String FUTSAL_COLUMN_CONTACT_NUMBER = "contactNumber";
    public static final String FUTSAL_COLUMN_RATING = "rating";
    private HashMap hp;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table futsalList" +
                "(id integer primary key, name text,address text,description text, longitude text, latitude text, contactNumber text, rating int )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertData  (String name, String address, String description,
                                String longitude,String latitude,
                                String contactNumber, int rating){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FUTSAL_COLUMN_NAME, name);
        contentValues.put(FUTSAL_COLUMN_Address, address);
        contentValues.put(FUTSAL_COLUMN_DESCRIPTION, description);
        contentValues.put(FUTSAL_COLUMN_LONGITUDE, longitude);
        contentValues.put(FUTSAL_COLUMN_LATITUDE, latitude);
        contentValues.put(FUTSAL_COLUMN_CONTACT_NUMBER, contactNumber);
        contentValues.put(FUTSAL_COLUMN_RATING, rating);
        db.insert(FUTSAL_TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, FUTSAL_COLUMN_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id,String name, String address, String description,
                                  String longitude,String latitude, String contactNumber, int rating)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FUTSAL_COLUMN_NAME, name);
        contentValues.put(FUTSAL_COLUMN_Address, address);
        contentValues.put(FUTSAL_COLUMN_DESCRIPTION, description);
        contentValues.put(FUTSAL_COLUMN_LONGITUDE, longitude);
        contentValues.put(FUTSAL_COLUMN_LATITUDE, latitude);
        contentValues.put(FUTSAL_COLUMN_CONTACT_NUMBER, contactNumber);
        contentValues.put(FUTSAL_COLUMN_RATING, rating);
        db.update(FUTSAL_TABLE_NAME, contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteData (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(FUTSAL_TABLE_NAME,
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public List<InformationData> viewAllData()
    {
        List<InformationData> array_list = new ArrayList<>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+FUTSAL_TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(new InformationData(res.getString(res.getColumnIndex(FUTSAL_COLUMN_NAME)),
                    res.getString(res.getColumnIndex(FUTSAL_COLUMN_Address)),
                    res.getString(res.getColumnIndex(FUTSAL_COLUMN_DESCRIPTION)),
                    res.getString(res.getColumnIndex(FUTSAL_COLUMN_LONGITUDE)),
                    res.getString(res.getColumnIndex(FUTSAL_COLUMN_LATITUDE)),
                    res.getInt(res.getColumnIndex(FUTSAL_COLUMN_RATING)),
                            res.getString(res.getColumnIndex(FUTSAL_COLUMN_CONTACT_NUMBER)))
                    );
            res.moveToNext();
        }
        return array_list;
    }
}