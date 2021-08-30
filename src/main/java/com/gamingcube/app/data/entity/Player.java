package com.gamingcube.app.data.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {

  @Id
  @Column(name = "ID")
  private Long id;

  private String name;

  @Transient
  private BigDecimal value;

  @ManyToOne(cascade = CascadeType.REMOVE)
  @JoinColumn(name = "clubID")
  @JsonIgnoreProperties("players")
  private Club club;

  @Override
  public String toString() {
    return "Player [id=" + id + ", name=" + name + ", value=" + value + ", club=" + club.getName() + "]";
  }

}
