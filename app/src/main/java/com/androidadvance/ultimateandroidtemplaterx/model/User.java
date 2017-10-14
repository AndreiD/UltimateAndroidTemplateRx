package com.androidadvance.ultimateandroidtemplaterx.model;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Uid;
import io.objectbox.relation.ToMany;

@Entity public class User {

  @Id public long id;

  String fullName;
  String email;

  @Backlink
  public ToMany<Meal> meals;

  public User() {

  }

  public User(long id, String fullName, String email) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return fullName;
  }

  public void setName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override public String toString() {
    return "User{" + "id=" + id + ", name='" + fullName + '\'' + ", email='" + email + '\'' + '}';
  }
}
