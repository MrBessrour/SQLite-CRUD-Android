package com.bessrour.sqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Product> {
    public CustomAdapter(@NonNull Context context, ArrayList<Product> poroducts) {
        super(context, R.layout.custom_row ,poroducts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext()) ;
        View customview = inflater.inflate(R.layout.custom_row,parent,false) ;

        Product product = getItem(position) ;

        TextView id = (TextView) customview.findViewById(R.id.id) ;
        TextView name = (TextView) customview.findViewById(R.id.name) ;
        TextView quantity = (TextView) customview.findViewById(R.id.quan) ;


        id.setText("ID : "+(product.Id).toString());
        name.setText("Name : " +product.Name);
        quantity.setText("Quantity : " +(product.Quantity).toString());

        customview.setTag(product.Id);
        return customview ;

//        return super.getView(position, convertView, parent);

    }
}
