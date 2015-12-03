package com.dlis.app.service;

import com.dlis.app.model.Tags;
import com.dlis.app.model.Tags;

import java.util.Collection;

/**
 * Created by DLiszewski on 2015-11-13.
 */
public interface TagsService {
    Collection<Tags> findBySeriesid(int seriesid);
    Tags create(Tags tag);
    Tags update(Tags tag);
    void delete(int id);
}
