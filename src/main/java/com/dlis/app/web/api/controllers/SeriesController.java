package com.dlis.app.web.api.controllers;

import com.dlis.app.model.Series;
import com.dlis.app.service.SeriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by DLiszewski on 2015-11-12.
 */
@RestController
@CrossOrigin
@RequestMapping("api/series")
public class SeriesController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeriesService seriesService;

    @RequestMapping(
            value = "",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Series>> getSeriess() {
        logger.info("> getSeries");
        Collection<Series> series = seriesService.findAll();
        logger.info("< getSeries2");
        return new ResponseEntity<Collection<Series>>(series, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Series> getSeries(@PathVariable("id") Integer id) {
        logger.info("> getSeries id: {}", id);
        Series series = seriesService.findOne(id);
        if (series == null) {
            return new ResponseEntity<Series>(HttpStatus.NOT_FOUND);
        }
        logger.info("< getSeries id:{}", id);
        return new ResponseEntity<Series>(series, HttpStatus.OK);
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Series> createSeries(@RequestBody Series series) {
        logger.info("> create Series");
        Series savedseries = seriesService.create(series);
        logger.info("< create Series");
        return new ResponseEntity<Series>(savedseries, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Series> updateSeries(@RequestBody Series series) {
        logger.info("> update series id:{}", series.getId());
        Series updateseries = seriesService.update(series);
        if (updateseries == null) {
            return new ResponseEntity<Series>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info("< update series id:{}", series.getId());
        return new ResponseEntity<Series>(updateseries, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Series> deleteSeries(@PathVariable Integer id) {
        logger.info("> delete series id:{}", id);
        seriesService.delete(id);
        logger.info("< delete series id:{}", id);
        return new ResponseEntity<Series>(HttpStatus.NO_CONTENT);
    }

}
