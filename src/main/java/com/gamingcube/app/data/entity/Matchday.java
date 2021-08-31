package com.gamingcube.app.data.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Matchday {

  @Id
  @Column(name = "ID")
  private long id;

  private LocalTime deadline;

  @NotNull
  private String name;

  private LocalDate startDate;

  private LocalDate endDate;

  @OneToMany(mappedBy = "matchday", fetch = FetchType.EAGER)
  private List<Players2Matchdays> players2matchdays;

}
