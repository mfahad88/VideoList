
package com.example.videolist.models.videopopular;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class VideoFile {

    @SerializedName("file_type")
    private String fileType;
    @Expose
    private Long height;
    @Expose
    private Long id;
    @Expose
    private String link;
    @Expose
    private String quality;
    @Expose
    private Long width;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "VideoFile{" +
                "fileType='" + fileType + '\'' +
                ", height=" + height +
                ", id=" + id +
                ", link='" + link + '\'' +
                ", quality='" + quality + '\'' +
                ", width=" + width +
                '}';
    }
}
