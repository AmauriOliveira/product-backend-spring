package com.oliveira.amauri.product_backend.models;

public class Product {
  private int id;
  private String name;
  private String description;
  private int idCategory;
  private boolean onSale;
  private boolean launching;
  private double price;

  public Product() {
  }

  public Product(int id, String name, String description, int idCategory, boolean onSale, boolean launching, double price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.idCategory = idCategory;
    this.onSale = onSale;
    this.launching = launching;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getIdCategory() {
    return idCategory;
  }

  public void setCategory(int idCategory) {
    this.idCategory = idCategory;
  }

  public boolean isOnSale() {
    return onSale;
  }

  public void setOnSale(boolean onSale) {
    this.onSale = onSale;
  }

  public boolean isLaunching() {
    return launching;
  }

  public void setLaunching(boolean launching) {
    this.launching = launching;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
