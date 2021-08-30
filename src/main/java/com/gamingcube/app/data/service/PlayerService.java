package com.gamingcube.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import com.gamingcube.app.data.entity.Player;
import com.gamingcube.app.data.repository.PlayerRepository;

@Service
public class PlayerService extends CrudService<Player, Long> {

  private PlayerRepository playerRepository;

  public PlayerService(@Autowired PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  @Override
  protected PlayerRepository getRepository() {
    return playerRepository;
  }

}
