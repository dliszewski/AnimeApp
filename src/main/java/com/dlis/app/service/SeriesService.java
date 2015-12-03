package com.dlis.app.service;

import com.dlis.app.model.Series;

import java.util.Collection;

/**
 * Created by DLiszewski on 2015-11-13.
 */
public interface SeriesService {
    Collection<Series> findAll();
    Series findOne(int id);
    Series create(Series car);
    Series update(Series car);
    void delete(int id);
}
