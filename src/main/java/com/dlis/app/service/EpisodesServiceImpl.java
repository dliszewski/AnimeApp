package com.dlis.app.service;

import com.dlis.app.model.Episodes;
import com.dlis.app.repository.EpisodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Collection;

/**
 * Created by DLiszewski on 2015-11-13.
 */
@Service
public class EpisodesServiceImpl implements EpisodesService{

    @Autowired
    private EpisodesRepository episodesRepository;

    @Override
    public Collection<Episodes> findAll() {
        Collection<Episodes> episodes = episodesRepository.findAll();
        return episodes;
    }

    @Override
    public Collection<Episodes> findBySeriesid(int seriesid) {

        Collection<Episodes> episodes = episodesRepository.findBySeriesid(seriesid);
        return episodes;
    }

    @Override
    public Collection<Episodes> findLatest(int limit) {
        Collection<Episodes> episodes = episodesRepository.findLatest(limit);
        return episodes;
    }

    @Override
    public Episodes findOne(int id) {
       Episodes episodes = episodesRepository.findOne(id);
        return episodes;
    }

    @Override
    public Episodes create(Episodes episodes) {
        Integer episodesid = episodes.getId();
//        if (episodes!=null) {
//            throw new EntityExistsException(
//                    "Cannot create new Greeting with supplied id.  The id attribute must be null to create an entity.");
//        }
        Episodes savedEpisodes = episodesRepository.save(episodes);
        return savedEpisodes;
    }

    @Override
    public Episodes update(Episodes episodes) {
        Episodes episodesToUpdate = findOne(episodes.getId());
        if(episodesToUpdate == null){
            throw new NoResultException("Requested Greeting not found.");
        }

        episodesToUpdate.setTitle(episodes.getTitle());
        episodesToUpdate.setTimesrated(episodes.getTimesrated());
        episodesToUpdate.setSummary(episodes.getSummary());
        episodesToUpdate.setAdded(episodes.getAdded());
        episodesToUpdate.setNumber(episodes.getNumber());
        episodesToUpdate.setSeotitle(episodes.getSeotitle());
        episodesToUpdate.setRating(episodes.getRating());
        episodesToUpdate.setSeriesBySeriesid(episodes.getSeriesBySeriesid());
//        episodesToUpdate.setSeriesid(episodes.getSeriesid());
        episodesToUpdate.setVideo(episodes.getVideo());
        episodesToUpdate.setVideomirror(episodes.getVideomirror());
        episodesToUpdate.setView(episodes.getView());
        Episodes updateEpisodes= episodesRepository.save(episodesToUpdate);
        return updateEpisodes;
    }

    @Override
    public void delete(int id) {
        episodesRepository.delete(id);
    }
}
