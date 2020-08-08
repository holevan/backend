package com.familyTree.hlv.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "marriage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marriage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer pid;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "descendant_id", referencedColumnName = "id", nullable = false)
  private Person descendant;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "spouse_id", referencedColumnName = "id", nullable = false)
  private Person spouse;

  @Column(name="index")
  private Integer index;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
  private List<Person> children = new ArrayList<>();
}
