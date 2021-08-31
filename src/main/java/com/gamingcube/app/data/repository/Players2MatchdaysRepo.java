package com.gamingcube.app.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamingcube.app.data.entity.Matchday;
import com.gamingcube.app.data.entity.Players2Matchdays;
import com.gamingcube.app.data.entity.Players2MatchdaysID;

@Repository
public interface Players2MatchdaysRepo extends JpaRepository<Players2Matchdays, Players2MatchdaysID> {

  List<Players2Matchdays> findByMatchday(Matchday matchday);

  @Query(nativeQuery = true)
  List<Object[]> getPriceChangesByMatchday(@Param("matchday") Matchday matchday);

}
