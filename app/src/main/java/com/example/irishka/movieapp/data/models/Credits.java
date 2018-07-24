
package com.example.irishka.movieapp.data.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Credits {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("cast")
    @Expose
    private List<CastModel> cast = null;
    @SerializedName("crew")
    @Expose
    private List<CrewModel> crew = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CastModel> getCast() {
        return cast;
    }

    public void setCast(List<CastModel> cast) {
        this.cast = cast;
    }

    public List<CrewModel> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewModel> crew) {
        this.crew = crew;
    }

}
