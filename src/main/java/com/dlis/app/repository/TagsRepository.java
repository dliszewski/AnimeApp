package com.dlis.app.repository;

import com.dlis.app.model.Episodes;
import com.dlis.app.model.Series;
import com.dlis.app.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by DLiszewski on 2015-11-13.
 */
@Repository
public interface TagsRepository extends JpaRepository<Tags,Integer> {
    @Query(value = "SELECT * FROM tags t where t.seriesId = ?1", nativeQuery=true)
    Collection<Tags> findBySeriesid(int seriesId);
}
