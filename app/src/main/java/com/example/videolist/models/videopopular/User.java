
package com.example.videolist.models.videopopular;


import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class User {

    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
