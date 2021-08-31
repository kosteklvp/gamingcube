package com.gamingcube.app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamingcube.app.data.entity.Club;

@Repository
public interface ClubRepo extends JpaRepository<Club, Long> {

}
