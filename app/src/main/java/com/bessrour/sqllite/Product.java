package com.bessrour.sqllite;

import android.content.Intent;

public class Product {
    Integer Id ;
    String Name ;
    Integer Quantity ;

    public Product(){}

    public Product(Integer id, String name, Integer quantity) {
        Id = id;
        Name = name;
        Quantity = quantity;
    }
}
