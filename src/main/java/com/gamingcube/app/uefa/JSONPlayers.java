package com.gamingcube.app.uefa;

import static java.util.stream.Collectors.toSet;

import java.util.Objects;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.gamingcube.app.data.entity.Club;
import com.gamingcube.app.data.entity.Player;

public class JSONPlayers {

  private final String jsonContent;

  public JSONPlayers(String jsonContent) {
    this.jsonContent = Objects.requireNonNull(jsonContent);
  }

  public Set<Club> getClubs() throws ParseException {
    JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonContent);
    JSONObject jsonData = (JSONObject) jsonObject.get(UEFAData.JSONKey.DATA.get());
    JSONObject jsonValue = (JSONObject) jsonData.get(UEFAData.JSONKey.VALUE.get());
    JSONArray jsonPlayerList = (JSONArray) jsonValue.get(UEFAData.PlayersJSONKey.PLAYER_LIST.get());

    Set<Club> clubs = (Set<Club>) jsonPlayerList.stream()
        .map(jsonPlayer -> Club.builder()
            .id(Long.parseLong((String) ((JSONObject) jsonPlayer).get(UEFAData.PlayersJSONKey.TEAM_ID.get())))
            .code((String) ((JSONObject) jsonPlayer).get(UEFAData.PlayersJSONKey.TEAM_CODE.get()))
            .name((String) ((JSONObject) jsonPlayer).get(UEFAData.PlayersJSONKey.TEAM_NAME.get()))
            .build())
        .collect(toSet());

    return clubs;
  }

  public Set<Player> getPlayers() throws ParseException {
    JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonContent);
    JSONObject jsonData = (JSONObject) jsonObject.get(UEFAData.JSONKey.DATA.get());
    JSONObject jsonValue = (JSONObject) jsonData.get(UEFAData.JSONKey.VALUE.get());
    JSONArray jsonPlayerList = (JSONArray) jsonValue.get(UEFAData.PlayersJSONKey.PLAYER_LIST.get());

    Set<Player> players = (Set<Player>) jsonPlayerList.stream()
        .map(jsonPlayer -> Player.builder()
            .id(Long.parseLong((String) ((JSONObject) jsonPlayer).get(UEFAData.PlayersJSONKey.ID.get())))
            .name((String) ((JSONObject) jsonPlayer).get(UEFAData.PlayersJSONKey.NAME.get()))
            .club(Club.builder()
                .id(Long.parseLong((String) ((JSONObject) jsonPlayer).get(UEFAData.PlayersJSONKey.TEAM_ID.get())))
                .code((String) ((JSONObject) jsonPlayer).get(UEFAData.PlayersJSONKey.TEAM_CODE.get()))
                .name((String) ((JSONObject) jsonPlayer).get(UEFAData.PlayersJSONKey.TEAM_NAME.get()))
                .build())
            .build())
        .collect(toSet());

    return players;
  }

}
