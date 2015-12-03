package com.dlis.app.service;

import com.dlis.app.model.Series;
import com.dlis.app.repository.SeriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import java.util.Collection;

/**
 * Created by DLiszewski on 2015-11-13.
 */
@Service
public class SeriesServiceImpl implements SeriesService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeriesRepository seriesRepository;

    @Override
    public Collection<Series> findAll() {
       Collection<Series> series = seriesRepository.findAll();
        return series;
    }

    @Override
    public Series findOne(int id) {
        Series series = seriesRepository.findOne(id);
        return series;
    }

    @Override
    public Series create(Series series) {
        logger.info("> create Series");
        Integer seriesid = series.getId();
        int p = series.getId();
//        if (seriesid!=null) {
//            throw new EntityExistsException(
//                    "Cannot create new Greeting with supplied id.  The id attribute must be null to create an entity.");
//        }
        Series savedSeries = seriesRepository.save(series);
        return savedSeries;
    }

    @Override
    public Series update(Series series) {
        Series seriesToUpdate = findOne(series.getId());
        if (seriesToUpdate == null) {
            throw new NoResultException("Requested Greeting not found.");
        }

        seriesToUpdate.setCoverimg(series.getCoverimg());
        seriesToUpdate.setOrgtitle(series.getOrgtitle());
        seriesToUpdate.setRating(series.getRating());
        seriesToUpdate.setSeotitle(series.getSeotitle());
        seriesToUpdate.setStatus(series.getStatus());
        seriesToUpdate.setSummary(series.getSummary());
        seriesToUpdate.setTimesrated(series.getTimesrated());
        seriesToUpdate.setTyp(series.getTyp());
        seriesToUpdate.setViews(series.getViews());
        seriesToUpdate.setTitle(series.getTitle());
        Series updatedSeries = seriesRepository.save(seriesToUpdate);
        return updatedSeries;
    }

    @Override
    public void delete(int id) {
        seriesRepository.delete(id);
    }
}
