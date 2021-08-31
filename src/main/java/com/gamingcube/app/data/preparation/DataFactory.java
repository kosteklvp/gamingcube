package com.gamingcube.app.data.preparation;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;

public class DataFactory {

  @AllArgsConstructor
  enum MatchdaySettedUp {
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
      return Stream.of(MatchdaySettedUp.values()).map(m -> m.name).collect(Collectors.toSet());
    }

  }

}
