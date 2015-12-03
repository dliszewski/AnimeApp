package com.dlis.app.repository;

import com.dlis.app.model.Episodes;
import com.dlis.app.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by DLiszewski on 2015-11-13.
 */
@Repository
public interface EpisodesRepository extends JpaRepository<Episodes,Integer> {

    @Query(value = "SELECT * FROM episodes t where t.seriesId = ?1", nativeQuery=true)
    Collection<Episodes> findBySeriesid(int seriesId);

    @Query(value = "SELECT * FROM episodes ORDER BY added DESC LIMIT ?1", nativeQuery=true)
    Collection<Episodes> findLatest(int limit);
}
