package com.gamingcube.app.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import com.gamingcube.app.data.entity.Player;
import com.gamingcube.app.data.repository.PlayerRepo;

@Service
public class PlayerService extends CrudService<Player, Long> {

  private PlayerRepo playerRepo;

  public PlayerService(@Autowired PlayerRepo playerRepo) {
    this.playerRepo = playerRepo;
  }

  @Override
  protected PlayerRepo getRepository() {
    return playerRepo;
  }

}
