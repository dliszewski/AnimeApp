package com.dlis.app.service;

import com.dlis.app.model.Tags;
import com.dlis.app.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by DLiszewski on 2015-11-13.
 */
@Service
public class TagsServiceImpl implements TagsService {
    @Autowired
    private TagsRepository tagsRepository;

    @Override
    public Collection<Tags> findBySeriesid(int seriesid) {
        Collection<Tags> tags = tagsRepository.findBySeriesid(seriesid);
        return tags;
    }

    @Override
    public Tags create(Tags tag) {
        Tags savedTag = tagsRepository.save(tag);
        return savedTag;
    }


    @Override
    public Tags update(Tags tag) {

        return null;
    }

    @Override
    public void delete(int id) {
        tagsRepository.delete(id);
    }
}
