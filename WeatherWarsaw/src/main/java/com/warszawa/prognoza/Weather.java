package com.warszawa.prognoza;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Weather {
  private double id;
  private String main;
  private String description;
  private String clouds;

  public double getId() {
    return id;
  }

  public void setId(double id) {
    this.id = id;
  }

  public String getMain() {
    return main;
  }

  public void setMain(String main) {
    this.main = main;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getClouds() {
    return clouds;
  }

  public void setClouds(String clouds) {
    this.clouds = clouds;
  }

  @Override
  public String toString() {
    return "Weather{" + "id=" + id + ", main=" + main + ", description="
        + description + ", clouds=" + clouds + '}';
  }

}
