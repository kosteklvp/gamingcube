package com.gamingcube.app.views.checkoutform;

import com.gamingcube.app.data.entity.Player;
import com.gamingcube.app.data.repository.PlayerRepository;
import com.gamingcube.app.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Players")
@Route(value = "players", layout = MainLayout.class)
public class PlayersView extends HorizontalLayout {

  private final PlayerRepository playerRepository;
  final Grid<Player> grid;

  public PlayersView(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
    this.grid = new Grid<>(Player.class);
    add(grid);
    listPlayers();
  }

  private void listPlayers() {
    grid.setItems(playerRepository.findAll());
  }
}
