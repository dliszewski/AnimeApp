package com.dlis.app.web.api.controllers;

import com.dlis.app.model.Episodes;
import com.dlis.app.model.Tags;
import com.dlis.app.service.TagsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by DLiszewski on 2015-12-03.
 */
@RestController
@CrossOrigin
@RequestMapping("api/tags")
public class TagsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TagsService tagsService;

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Tags>> getEpisodes(@PathVariable("id") Integer id) {
        logger.info("> getEpisodes id: {}", id);
        Collection<Tags> tags = tagsService.findBySeriesid(id);
        if (tags == null) {
            return new ResponseEntity<Collection<Tags>>(HttpStatus.NOT_FOUND);
        }
        logger.info("< getEpisodes id:{}", id);
        return new ResponseEntity<Collection<Tags>>(tags, HttpStatus.OK);
    }
}
