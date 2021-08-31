package com.gamingcube.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudService;

import com.gamingcube.app.data.entity.Matchday;
import com.gamingcube.app.data.repository.MatchdayRepo;

public class MatchdayService extends CrudService<Matchday, Long> {

  private MatchdayRepo matchdayRepo;

  public MatchdayService(@Autowired MatchdayRepo matchdayRepo) {
    this.matchdayRepo = matchdayRepo;
  }

  @Override
  protected MatchdayRepo getRepository() {
    return matchdayRepo;
  }

}
