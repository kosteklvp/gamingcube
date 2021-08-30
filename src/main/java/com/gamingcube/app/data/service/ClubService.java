package com.gamingcube.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import com.gamingcube.app.data.entity.Club;
import com.gamingcube.app.data.repository.ClubRepository;

@Service
public class ClubService extends CrudService<Club, Long> {

  private ClubRepository clubRepository;

  public ClubService(@Autowired ClubRepository clubRepository) {
    this.clubRepository = clubRepository;
  }

  @Override
  protected ClubRepository getRepository() {
    return clubRepository;
  }

}
