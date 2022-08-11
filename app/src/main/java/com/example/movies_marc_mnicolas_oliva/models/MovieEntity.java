package com.example.movies_marc_mnicolas_oliva.models;
// table has a name
// table has columns (attributes) that define the data you're storing in the table

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movies_table")
public class MovieEntity {
    private String title;
    private int quantity;

    @PrimaryKey
    private int id;

    public MovieEntity(String title, int quantity, int id){
        this.title = title;
        this.quantity = quantity;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "MovieEntity{" +
                "title='" + title + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
