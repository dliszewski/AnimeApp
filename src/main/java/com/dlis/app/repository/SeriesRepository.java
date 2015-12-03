package com.dlis.app.repository;

import com.dlis.app.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DLiszewski on 2015-11-12.
 */
@Repository
public interface SeriesRepository extends JpaRepository<Series,Integer> {


}
