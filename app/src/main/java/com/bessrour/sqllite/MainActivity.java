package com.bessrour.sqllite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText id , name , quan ;
    Button add ;
//    DataBaseHandler dataBaseHandler ;
    ProductDAO DAO ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText)  findViewById(R.id.id) ;
        name = (EditText)  findViewById(R.id.name) ;
        quan = (EditText) findViewById(R.id.quan) ;

        add = (Button) findViewById(R.id.add) ;
        DAO = new ProductDAO(this) ;



        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Integer quantity = Integer.parseInt(quan.getText().toString()) ;
                Integer idProduct = Integer.parseInt(id.getText().toString()) ;
                String nameProduct = name.getText().toString() ;

                Product p = new Product(idProduct, nameProduct , quantity) ;
                if(DAO.insertdata(p) == 1){
                    Toast.makeText(getApplicationContext(),"add successfuly",Toast.LENGTH_SHORT) ;
                }else {
                    Toast.makeText(getApplicationContext(),"erro",Toast.LENGTH_SHORT) ;
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.show : show() ;
        }
        return super.onOptionsItemSelected(item);
    }

    public void show(){
        Intent I = new Intent(getApplicationContext(),ShowData.class) ;
        startActivity(I);
    }
}
