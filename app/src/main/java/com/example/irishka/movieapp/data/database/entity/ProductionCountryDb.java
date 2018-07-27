
package com.example.irishka.movieapp.data.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ProductionCountryDb {

    public ProductionCountryDb(String name){
        this.name = name;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
