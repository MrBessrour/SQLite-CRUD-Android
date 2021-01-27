package com.bessrour.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProductDAO {
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS product " ;
    public static final String CREATE_TABLE = "create table product ( id INTEGER PRIMARY KEY, name TEXT, quantity INTEGER);" ;
    public DataBaseHandler dataBaseHandler ;

    public ProductDAO(Context context){
        dataBaseHandler = new DataBaseHandler(context) ;
    }
    public int insertdata(Product p){
        try {
            SQLiteDatabase db = dataBaseHandler.getWritableDatabase() ;
            ContentValues values = new ContentValues() ;
            values.put("id" , p.Id);
            values.put("name" , p.Name);
            values.put("quantity" , String.valueOf(p.Quantity));
            db.insert("product" , null , values) ;
            db.close();
            return 1 ;
        }catch (Exception e){
            return 0 ;
        }

    }

    public int deletedata(Integer first){
        try{
            SQLiteDatabase db = dataBaseHandler.getWritableDatabase() ;
            db.delete("product" , "id='"+first+"'" , null) ;
            db.close();
            return 1 ;
        }catch (Exception e){
            return 0 ;
        }

    }

    public Cursor showdata(){
        try{
            SQLiteDatabase db = dataBaseHandler.getReadableDatabase() ;
            String req = "SELECT * FROM product" ;
            Cursor c = db.rawQuery(req,null) ;
            return c ;
        }catch (Exception e){
            return  null ;
        }

    }

}
