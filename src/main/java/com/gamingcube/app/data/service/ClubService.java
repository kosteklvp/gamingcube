package com.gamingcube.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import com.gamingcube.app.data.entity.Club;
import com.gamingcube.app.data.repository.ClubRepo;

@Service
public class ClubService extends CrudService<Club, Long> {

  private ClubRepo clubRepo;

  public ClubService(@Autowired ClubRepo clubRepo) {
    this.clubRepo = clubRepo;
  }

  @Override
  protected ClubRepo getRepository() {
    return clubRepo;
  }

}
