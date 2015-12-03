package com.dlis.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by DLiszewski on 2015-11-12.
 */
@Entity
public class Series {

    private int id;
    private String title;
    private String typ;
    private String status;
    private String summary;
    private String orgtitle;
    private String coverimg;
    private String seotitle;
    private Integer rating;
    private Integer timesrated;
    private Integer views;
//    @JsonBackReference
    private Collection<Episodes> episodesById;
    private Collection<Tags> tagsById;

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

    
    @Column(name = "typ", nullable = true, insertable = true, updatable = true, length = 50)
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    
    @Column(name = "status", nullable = true, insertable = true, updatable = true, length = 50)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    @Column(name = "summary", nullable = true, insertable = true, updatable = true, length = 1500)
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    
    @Column(name = "orgtitle", nullable = true, insertable = true, updatable = true, length = 250)
    public String getOrgtitle() {
        return orgtitle;
    }

    public void setOrgtitle(String orgtitle) {
        this.orgtitle = orgtitle;
    }

    
    @Column(name = "coverimg", nullable = true, insertable = true, updatable = true, length = 250)
    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }

    
    @Column(name = "seotitle", nullable = true, insertable = true, updatable = true, length = 250)
    public String getSeotitle() {
        return seotitle;
    }

    public void setSeotitle(String seotitle) {
        this.seotitle = seotitle;
    }

    
    @Column(name = "rating", nullable = true, insertable = true, updatable = true)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    
    @Column(name = "timesrated", nullable = true, insertable = true, updatable = true)
    public Integer getTimesrated() {
        return timesrated;
    }

    public void setTimesrated(Integer timesrated) {
        this.timesrated = timesrated;
    }

    
    @Column(name = "views", nullable = true, insertable = true, updatable = true)
    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Series series = (Series) o;

        if (id != series.id) return false;
        if (title != null ? !title.equals(series.title) : series.title != null) return false;
        if (typ != null ? !typ.equals(series.typ) : series.typ != null) return false;
        if (status != null ? !status.equals(series.status) : series.status != null) return false;
        if (summary != null ? !summary.equals(series.summary) : series.summary != null) return false;
        if (orgtitle != null ? !orgtitle.equals(series.orgtitle) : series.orgtitle != null) return false;
        if (coverimg != null ? !coverimg.equals(series.coverimg) : series.coverimg != null) return false;
        if (seotitle != null ? !seotitle.equals(series.seotitle) : series.seotitle != null) return false;
        if (rating != null ? !rating.equals(series.rating) : series.rating != null) return false;
        if (timesrated != null ? !timesrated.equals(series.timesrated) : series.timesrated != null) return false;
        if (views != null ? !views.equals(series.views) : series.views != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (typ != null ? typ.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (orgtitle != null ? orgtitle.hashCode() : 0);
        result = 31 * result + (coverimg != null ? coverimg.hashCode() : 0);
        result = 31 * result + (seotitle != null ? seotitle.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (timesrated != null ? timesrated.hashCode() : 0);
        result = 31 * result + (views != null ? views.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "seriesBySeriesid")
    public Collection<Episodes> getEpisodesById() {
        return episodesById;
    }

    public void setEpisodesById(Collection<Episodes> episodesById) {
        this.episodesById = episodesById;
    }


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tagsBySeriesid")
    public Collection<Tags> getTagsById() {
        return tagsById;
    }

    public void setTagsById(Collection<Tags> tagsById) {
        this.tagsById = tagsById;
    }
}
