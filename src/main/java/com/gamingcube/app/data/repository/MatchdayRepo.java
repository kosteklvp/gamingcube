package com.gamingcube.app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamingcube.app.data.entity.Matchday;

@Repository
public interface MatchdayRepo extends JpaRepository<Matchday, Long> {

  Matchday findTopByOrderByIdDesc();

}
