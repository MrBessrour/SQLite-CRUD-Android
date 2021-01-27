package com.bessrour.sqllite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {

    ArrayList<Product> products = new ArrayList<>() ;
    ProductDAO DAO  ;
    ListView products_list ;
    DataBaseHandler dataBaseHandler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        DAO = new ProductDAO(this) ;
        products_list = findViewById(R.id.list) ;
        registerForContextMenu(products_list);

        Cursor c = DAO.showdata() ;
        if(c.getCount() == 0 ){
            //no data found
        }
        else {
            while (c.moveToNext()){
                Product p = new Product(c.getInt(0),c.getString(1) ,c.getInt(2));
                products.add(p) ;
            }
        }

        CustomAdapter customAdapter = new CustomAdapter(this,products) ;
        products_list.setAdapter(customAdapter);

        products_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int todelete = (int) view.getTag() ;
                DAO.deletedata(todelete);
                finish();
                startActivity(getIntent());
            }
        });

    }


}
