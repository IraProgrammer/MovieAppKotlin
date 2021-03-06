package com.example.irishka.movieapp.data.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.irishka.movieapp.data.database.converters.PhotosConverter;

import java.util.List;

@Entity
public class CastDb {

    @PrimaryKey
    private long id;

    private String name;

    private String profileUrl;

    private String birthday;

    private String biography;

    private String placeOfBirth;

    @TypeConverters(PhotosConverter.class)
    private List<ImageDb> photos;

    public long getId() {
        return id;
    }

    public void setId(long castId) {
        this.id = castId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public List<ImageDb> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ImageDb> photos) {
        this.photos = photos;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }


}
