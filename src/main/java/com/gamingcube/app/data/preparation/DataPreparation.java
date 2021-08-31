package com.gamingcube.app.data.preparation;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import com.gamingcube.app.data.entity.Club;
import com.gamingcube.app.data.entity.Player;
import com.gamingcube.app.data.repository.ClubRepo;
import com.gamingcube.app.data.repository.PlayerRepo;
import com.gamingcube.app.uefa.JSONPlayers;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class DataPreparation {

  private static final Logger log = LoggerFactory.getLogger(DataPreparation.class);

  private static final Path MAIN_JSON_FILE = Path.of("./src/main/resources/JSONFiles/Players.json");

//  @Bean
  public CommandLineRunner loadData(ClubRepo clubRepository, PlayerRepo playerRepository) {
    return args -> {
      String jsonContent = Files.readString(MAIN_JSON_FILE);

      if (isEmpty(jsonContent)) {
        log.info("JSON file is empty. Nothing was loaded.");
        return;
      }

      JSONPlayers jsonPlayers = new JSONPlayers(jsonContent);

      Set<Club> clubs = jsonPlayers.getClubs();
      clubRepository.saveAll(clubs);
      log.info(MessageFormat.format("Loaded {0} clubs to database.", clubs.size()));

      Set<Player> players = jsonPlayers.getPlayers();
      playerRepository.saveAll(players);
      log.info(MessageFormat.format("Loaded {0} players to database.", players.size()));

    };
  }

}
