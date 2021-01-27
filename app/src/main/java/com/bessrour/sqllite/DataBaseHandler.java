package com.bessrour.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1 ;
    public static final String DATABASE_NAME = "product.db" ;
    private Context context;

//    public DataBaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
//
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL(ProductDAO.CREATE_TABLE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL(ProductDAO.DROP_TABLE);
//        onCreate(sqLiteDatabase);
//    }
    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(ProductDAO.CREATE_TABLE);
        } catch (Exception e) {
//            Message.message(context,""+e);
            Toast.makeText(context,"error",Toast.LENGTH_LONG) ;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(ProductDAO.DROP_TABLE);
            onCreate(db);
        }catch (Exception e) {
            Toast.makeText(context,"error",Toast.LENGTH_LONG) ;
        }
    }


}
