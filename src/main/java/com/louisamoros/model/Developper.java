package com.louisamoros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by louis on 01/03/17.
 */
@Entity
public class Developper {

  @Id
  private UUID id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  // CHECKSTYLE_OFF
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Developper developper = (Developper) o;
    return Objects.equals(lastName, developper.lastName) &&
        Objects.equals(firstName, developper.firstName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastName, firstName);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("firstName='").append(firstName);
    sb.append(", id='").append(id);
    sb.append(", lastName='").append(lastName);
    sb.append('}');
    return sb.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private final Developper developper;

    private Builder() {
      developper = new Developper();
    }

    public Builder id(UUID id) {
      developper.setId(id);
      return this;
    }

    public Builder firstName(String firstName) {
      developper.setFirstName(firstName);
      return this;
    }

    public Builder lastName(String lastName) {
      developper.setLastName(lastName);
      return this;
    }

    public Developper build() {
      return developper;
    }

  }
  // CHECKSTYLE_ON

}
