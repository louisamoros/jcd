package com.louisamoros.model;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Louis Amoros on 03/03/17.
 */
public class Language {

  @Id
  private String name;
  @Column
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
