
package com.example.videolist.models.videopopular;


import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class VideoPicture {

    @Expose
    private Long id;
    @Expose
    private Long nr;
    @Expose
    private String picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNr() {
        return nr;
    }

    public void setNr(Long nr) {
        this.nr = nr;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "VideoPicture{" +
                "id=" + id +
                ", nr=" + nr +
                ", picture='" + picture + '\'' +
                '}';
    }
}
