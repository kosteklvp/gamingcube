package com.gamingcube.app.uefa;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UEFAData {
  private static final String MAIN_URL = "https://gaming.uefa.com/en/uclfantasy";

  public static final String DEFAULT_LANGUAGE = "en";

  @AllArgsConstructor
  enum MatchdayName {
    // GROUP STAGE
    MATCHDAY1("Group stage - Matchday 1"),
    MATCHDAY2("Group stage - Matchday 2"),
    MATCHDAY3("Group stage - Matchday 3"),
    MATCHDAY4("Group stage - Matchday 4"),
    MATCHDAY5("Group stage - Matchday 5"),
    MATCHDAY6("Group stage - Matchday 6"),

    // KNOCKOUT STAGE
    MATCHDAY7("Round of 16 - 1st leg"),
    MATCHDAY8("Round of 16 - 2st leg"),
    MATCHDAY9("Quarter-finals - 1st leg"),
    MATCHDAY10("Quarter-finals - 2st leg"),
    MATCHDAY11("Semi-finals - 1st leg"),
    MATCHDAY12("Semi-finals - 2st leg"),
    MATCHDAY13("Final");

    private final String name;

    public static Set<String> getNames() {
      return Stream.of(MatchdayName.values()).map(m -> m.name).collect(Collectors.toSet());
    }

  }

  @AllArgsConstructor
  public enum ServiceURL {
    PLAYERS(MAIN_URL + "/services/api/Feed/players"),
    LIVE_MIXED(MAIN_URL + "/services/api/Live/mixed");

    private final String url;

    public String get() {
      return url;
    }

  }

  @AllArgsConstructor
  public enum JSONKey {
    DATA("data"),
    VALUE("value"),
    ID("id");

    private final String key;

    public String get() {
      return key;
    }
  }

  @AllArgsConstructor
  public enum LiveMixedJSONKey {
    DEADLINE("Deadline"),
    FIXTURE("Fixture"),
    MATCHDAY_ID("mdId");

    private final String key;

    public String get() {
      return key;
    }
  }

  @AllArgsConstructor
  public enum PlayersJSONKey {
    NAME("pFName"),
    ID("id"),
    VALUE("value"),
    TEAM_ID("tId"),
    TEAM_CODE("cCode"),
    TEAM_NAME("tName"),
    PLAYER_LIST("playerList"),
    GAMEDAY_ID("gamedayId"),
    LANGUAGE("language");

    private final String key;

    public String get() {
      return key;
    }
  }
}
