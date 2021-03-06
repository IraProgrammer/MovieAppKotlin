package com.example.irishka.movieapp.data.database.converters;

import android.arch.persistence.room.TypeConverter;

import com.example.irishka.movieapp.data.database.entity.ProductionCountryDb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountriesConverter {

    @TypeConverter
    public String fromCountriesList(List<ProductionCountryDb> countries) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < countries.size(); i++) {
            str.append(countries.get(i).getName()).append(", ");
            if (i == countries.size() - 1) str.deleteCharAt(str.length()-1);
        }
        return str.toString();
    }

    @TypeConverter
    public List<ProductionCountryDb> toCountriesList(String countriesStr) {
        List<String> names = Arrays.asList(countriesStr.split(","));

        List<ProductionCountryDb> countries = new ArrayList<>();

        for (String name: names) {
            countries.add(new ProductionCountryDb(name));
        }

        return countries;
    }

}