
package com.example.videolist.models.videopopular;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Popular {

    @Expose
    private Long page;
    @SerializedName("per_page")
    private Long perPage;
    @SerializedName("total_results")
    private Long totalResults;
    @Expose
    private String url;
    @Expose
    private List<Video> videos;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPerPage() {
        return perPage;
    }

    public void setPerPage(Long perPage) {
        this.perPage = perPage;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Popular{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", totalResults=" + totalResults +
                ", url='" + url + '\'' +
                ", videos=" + videos +
                '}';
    }
}
