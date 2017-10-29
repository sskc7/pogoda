package com.warszawa.prognoza;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class WeatherGeneral {
  private double cod;
  private double message;

  private List<WeatherList> list;

  public List<WeatherList> getList() {
    return list;
  }

  public void setList(List<WeatherList> list) {
    this.list = list;
  }

  public double getCod() {
    return cod;
  }

  public void setCod(double cod) {
    this.cod = cod;
  }

  public double getMessage() {
    return message;
  }

  public void setMessage(double message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "WeatherGeneral{" + "cod=" + cod + ", message=" + message + ", list="
        + list + '}';
  }

}
