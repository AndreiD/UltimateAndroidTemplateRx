package com.androidadvance.ultimateandroidtemplaterx.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.relation.ToOne;

@Entity
public class Meal {
  @Id public long id;

  @Index public String name;
  public String ingredients;
  public double price;

  public ToOne<User> user;

  public Meal() {

  }

  public Meal(long id, String name, String ingredients, double price) {
    this.id = id;
    this.name = name;
    this.ingredients = ingredients;
    this.price = price;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override public String toString() {
    return "Meal{" + "id=" + id + ", name='" + name + '\'' + ", ingredients='" + ingredients + '\'' + ", price=" + price + '}';
  }
}
