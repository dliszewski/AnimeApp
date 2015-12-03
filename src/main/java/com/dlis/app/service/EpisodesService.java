package com.dlis.app.service;

import com.dlis.app.model.Episodes;

import java.util.Collection;

/**
 * Created by DLiszewski on 2015-11-13.
 */
public interface EpisodesService {
    Collection<Episodes> findAll();
    Collection<Episodes> findBySeriesid(int seriesid);
    Collection<Episodes> findLatest(int limit);
    Episodes findOne(int id);
    Episodes create(Episodes car);
    Episodes update(Episodes car);
    void delete(int id);
}
