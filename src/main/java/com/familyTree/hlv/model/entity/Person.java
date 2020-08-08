package com.familyTree.hlv.model.entity;

import com.familyTree.hlv.constant.enumeration.Gender;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pid", referencedColumnName = "pid")
  private Marriage parent;

  private String name;

  @Enumerated
  private Gender gender;

  @Column(name = "alter_name")
  private String alterName;

  @Column(name = "child_no")
  private Integer childNo;

  private String dob;

  private String hometown;

  private String occupations;

  private Boolean alive;

  private String dod;

  @Column(name = "grave_location")
  private String graveLocation;

  private Integer age;

  private String address;

  private String note;

  private Integer generation;

  @OneToMany(mappedBy = "descendant", cascade = CascadeType.ALL)
  private List<Marriage> marriages = new ArrayList<>();
}
