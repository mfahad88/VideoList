
package com.example.videolist.models.videopopular;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Video {

    @SerializedName("avg_color")
    private Object avgColor;
    @Expose
    private Long duration;
    @SerializedName("full_res")
    private Object fullRes;
    @Expose
    private Long height;
    @Expose
    private Long id;
    @Expose
    private String image;
    @Expose
    private List<Object> tags;
    @Expose
    private String url;
    @Expose
    private User user;
    @SerializedName("video_files")
    private List<VideoFile> videoFiles;
    @SerializedName("video_pictures")
    private List<VideoPicture> videoPictures;
    @Expose
    private Long width;

    public Object getAvgColor() {
        return avgColor;
    }

    public void setAvgColor(Object avgColor) {
        this.avgColor = avgColor;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Object getFullRes() {
        return fullRes;
    }

    public void setFullRes(Object fullRes) {
        this.fullRes = fullRes;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<VideoFile> getVideoFiles() {
        return videoFiles;
    }

    public void setVideoFiles(List<VideoFile> videoFiles) {
        this.videoFiles = videoFiles;
    }

    public List<VideoPicture> getVideoPictures() {
        return videoPictures;
    }

    public void setVideoPictures(List<VideoPicture> videoPictures) {
        this.videoPictures = videoPictures;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

}
