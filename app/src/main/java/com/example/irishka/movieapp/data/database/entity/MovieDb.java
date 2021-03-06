
package com.example.irishka.movieapp.data.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.irishka.movieapp.data.database.converters.ImagesConverter;
import com.example.irishka.movieapp.data.database.converters.CountriesConverter;

import java.util.List;

@Entity
public class MovieDb {

    @PrimaryKey
    private long id;

    private String title;

    private String posterUrl;

    private String releaseDate;

    private boolean adult;

    private String voteAverageStr;

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    private double voteAverage;

    private int runtime;

    @TypeConverters(CountriesConverter.class)
    private List<ProductionCountryDb> countries;

    @TypeConverters(ImagesConverter.class)
    private List<ImageDb> backdrops;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    private String overview;

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getVoteAverageStr() {
        return voteAverageStr;
    }

    public void setVoteAverageStr(String voteAverageStr) {
        this.voteAverageStr = voteAverageStr;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<ProductionCountryDb> getCountries() {
        return countries;
    }

    public void setCountries(List<ProductionCountryDb> countries) {
        this.countries = countries;
    }

    public List<ImageDb> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<ImageDb> backdrops) {
        this.backdrops = backdrops;
    }
}
