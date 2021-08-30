package com.gamingcube.app.data.entity;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Club {

  @Id
  @Column(name = "ID")
  private Long id;

  private String name;

  private String code;

  @OneToMany(mappedBy = "club", cascade = REMOVE, fetch = EAGER)
  private List<Player> players;

  @Override
  public String toString() {
    return "Club [id=" + id + ", name=" + name + ", code=" + code + "]";
  }

}
