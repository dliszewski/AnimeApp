package com.dlis.app.web.api.controllers;

import com.dlis.app.model.Episodes;
import com.dlis.app.model.Series;
import com.dlis.app.model.Tags;
import com.dlis.app.service.EpisodesService;
import com.dlis.app.service.TagsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by DLiszewski on 2015-11-13.
 */
@RestController
@CrossOrigin
@RequestMapping("api/episodes")
public class EpisodesController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EpisodesService episodesService;
    @Autowired
    private TagsService tagsService;

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Episodes>> getEpisodess() {
        logger.info("> getEpisodess");
        Collection<Episodes> episodes = episodesService.findAll();
        logger.info("< getEpisodess");
        return new ResponseEntity<Collection<Episodes>>(episodes, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/s/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Episodes>> getEpisodessBySeries(@PathVariable("id") Integer id) {
        logger.info("> getEpisodessBySeries");
        Collection<Episodes> episodes = episodesService.findBySeriesid(id);
        logger.info("< getEpisodessBySeries");
        return new ResponseEntity<Collection<Episodes>>(episodes, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Episodes> getEpisodes(@PathVariable("id") Integer id) {
        logger.info("> getEpisodes id: {}", id);
        Episodes episodes = episodesService.findOne(id);
        if (episodes == null) {
            return new ResponseEntity<Episodes>(HttpStatus.NOT_FOUND);
        }
        logger.info("< getEpisodes id:{}", id);
        return new ResponseEntity<Episodes>(episodes, HttpStatus.OK);
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Episodes> createEpisodes(@RequestBody Episodes episodes) {
        logger.info("> create Episodes");
        Episodes savedepisodes = episodesService.create(episodes);
        logger.info("< create Episodes");
        return new ResponseEntity<Episodes>(savedepisodes, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Episodes> updateEpisodes(@RequestBody Episodes episodes) {
        logger.info("> update Episodes id:{}", episodes.getId());
        Episodes updateepisodes = episodesService.update(episodes);
        if (updateepisodes == null) {
            return new ResponseEntity<Episodes>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info("< update episodes id:{}", episodes.getId());
        return new ResponseEntity<Episodes>(updateepisodes, HttpStatus.OK);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Episodes> deleteEpisodes(@PathVariable Integer id) {
        logger.info("> delete episodes id:{}", id);
        episodesService.delete(id);
        logger.info("< delete episodes id:{}", id);
        return new ResponseEntity<Episodes>(HttpStatus.NO_CONTENT);
    }


//  Add Test data
    @RequestMapping(
            value = "/testdata/",
            method = RequestMethod.GET
    )
    public ResponseEntity<String> test() {
        final long MILLIS_IN_A_DAY = 1000*60*60*24;
        logger.info("> insert test data");
        for(int i=1;i<25;i++){
            Series s = new Series();
            s.setId(i);

            Tags tag1 = new Tags();
            tag1.setName("Test");
            List<Tags> list = new ArrayList<Tags>();
            list.add(tag1);
            s.setTagsById(list);
            tag1.setTagsBySeriesid(s);
            tagsService.create(tag1);
            for(int j=1;j<5;j++){
                Episodes episode = new Episodes();
                episode.setTitle(null);
                episode.setTimesrated(0);
                episode.setSummary(null);
                episode.setAdded(new java.sql.Date(new java.util.Date().getTime() - MILLIS_IN_A_DAY));
                episode.setNumber(j);
                episode.setSeotitle(null);
                episode.setRating(0d);
                episode.setSeriesBySeriesid(s);
//                episode.setSeriesid(Long.valueOf(i));
                episode.setVideo("http://www.mp4upload.com/embed-kmo14geakbvf.html");
                episode.setVideomirror("http://www.mp4upload.com/embed-kmo14geakbvf.html");
                episode.setView(0);
//                logger.info("<<<<<<<<< insert test data >>>>>>>>>> "+ episode.getSeriesid());
                episodesService.create(episode);
            }


        }

        for(int i=6;i<25;i++){
            Series s = new Series();
            s.setId(i);
            Episodes episode = new Episodes();
            episode.setTitle(null);
            episode.setTimesrated(0);
            episode.setSummary(null);
            episode.setAdded(new java.sql.Date(new java.util.Date().getTime()));
            episode.setNumber(5);
            episode.setSeotitle(null);
            episode.setRating(0d);
            episode.setSeriesBySeriesid(s);
            episode.setVideo("http://www.mp4upload.com/embed-kmo14geakbvf.html");
            episode.setVideomirror("http://www.mp4upload.com/embed-kmo14geakbvf.html");
            episode.setView(0);
            episodesService.create(episode);
        }

                logger.info("< insert test data");
        return new ResponseEntity<String>("test data inserted",HttpStatus.OK);
    }

    @RequestMapping(
            value = "/latest/{limit}",
            method = RequestMethod.GET
    )
    public ResponseEntity<Collection<Episodes>> getTop10(@PathVariable("limit") Integer limit) {
        logger.info("> insert test data");
        Collection<Episodes> episodes = episodesService.findLatest(limit);
        logger.info("< insert test data");
        return new ResponseEntity<Collection<Episodes>>(episodes,HttpStatus.OK);
    }

}
