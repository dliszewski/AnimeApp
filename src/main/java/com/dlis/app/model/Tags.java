package com.dlis.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by DLiszewski on 2015-11-13.
 */
@Entity
public class Tags {


    private int id;
    private Series tagsBySeriesid;
    private String name;
    private String seoname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @JsonIgnore
    @ManyToOne(optional = false,cascade = CascadeType.MERGE )
    @JoinColumn(name = "seriesid", referencedColumnName = "id")
    public Series getTagsBySeriesid() {
        return tagsBySeriesid;
    }

    public void setTagsBySeriesid(Series seriesId) {
        this.tagsBySeriesid = seriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeoname() {
        return seoname;
    }

    public void setSeoname(String seoname) {
        this.seoname = seoname;
    }
}
