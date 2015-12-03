package com.dlis.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DLiszewski on 2015-11-13.
 */
@Entity
public class Episodes {
    private int id;
    private String title;
    private Integer number;
    private String summary;
    private java.sql.Date added;
    private Integer view;
    private Double rating;
    private Integer timesrated;
    private String video;
    private String seotitle;
    private String videomirror;


//    @JsonManagedReference
    private Series seriesBySeriesid;

    public Episodes(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "title", nullable = true, insertable = true, updatable = true, length = 250)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Column(name = "number", nullable = true, insertable = true, updatable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    @Column(name = "summary", nullable = true, insertable = true, updatable = true, length = 250)
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    @Column(name = "added", nullable = true, insertable = true, updatable = true)
    public java.sql.Date getAdded() {
        return added;
    }

    public void setAdded(java.sql.Date added) {
        this.added = added;
    }


    @Column(name = "view", nullable = true, insertable = true, updatable = true)
    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }


    @Column(name = "rating", nullable = true, insertable = true, updatable = true, precision = 17)
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }


    @Column(name = "timesrated", nullable = true, insertable = true, updatable = true)
    public Integer getTimesrated() {
        return timesrated;
    }

    public void setTimesrated(Integer timesrated) {
        this.timesrated = timesrated;
    }


    @Column(name = "video", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }


    @Column(name = "seotitle", nullable = true, insertable = true, updatable = true, length = 250)
    public String getSeotitle() {
        return seotitle;
    }

    public void setSeotitle(String seotitle) {
        this.seotitle = seotitle;
    }


    @Column(name = "videomirror", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getVideomirror() {
        return videomirror;
    }

    public void setVideomirror(String videomirror) {
        this.videomirror = videomirror;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Episodes episodes = (Episodes) o;

        if (id != episodes.id) return false;
        if (title != null ? !title.equals(episodes.title) : episodes.title != null) return false;
        if (number != null ? !number.equals(episodes.number) : episodes.number != null) return false;
        if (summary != null ? !summary.equals(episodes.summary) : episodes.summary != null) return false;
        if (added != null ? !added.equals(episodes.added) : episodes.added != null) return false;
        if (view != null ? !view.equals(episodes.view) : episodes.view != null) return false;
        if (rating != null ? !rating.equals(episodes.rating) : episodes.rating != null) return false;
        if (timesrated != null ? !timesrated.equals(episodes.timesrated) : episodes.timesrated != null) return false;
        if (video != null ? !video.equals(episodes.video) : episodes.video != null) return false;
        if (seotitle != null ? !seotitle.equals(episodes.seotitle) : episodes.seotitle != null) return false;
        if (videomirror != null ? !videomirror.equals(episodes.videomirror) : episodes.videomirror != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (added != null ? added.hashCode() : 0);
        result = 31 * result + (view != null ? view.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (timesrated != null ? timesrated.hashCode() : 0);
        result = 31 * result + (video != null ? video.hashCode() : 0);
        result = 31 * result + (seotitle != null ? seotitle.hashCode() : 0);
        result = 31 * result + (videomirror != null ? videomirror.hashCode() : 0);
        return result;
    }


    @ManyToOne(optional = false,cascade = CascadeType.MERGE )
    @JoinColumn(name = "seriesid", referencedColumnName = "id",nullable = false)
    public Series getSeriesBySeriesid() {
        return seriesBySeriesid;
    }

    public void setSeriesBySeriesid(Series seriesBySeriesid) {
        this.seriesBySeriesid = seriesBySeriesid;
    }
}
