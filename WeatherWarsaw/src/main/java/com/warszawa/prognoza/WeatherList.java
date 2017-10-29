package com.warszawa.prognoza;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class WeatherList {
  private long dt;
  private Date dt_txt;
  private WeatherMain main;
  private WeatherClouds clouds;
  public WeatherMain getMain() {
    return main;
  }

  public void setMain(WeatherMain main) {
    this.main = main;
  }

  public WeatherClouds getClouds() {
    return clouds;
  }

  public void setClouds(WeatherClouds clouds) {
    this.clouds = clouds;
  }

  public Date getDt_txt() {
    return dt_txt;
  }

  public void setDt_txt(Date dt_txt) {
    this.dt_txt = dt_txt;
  }

  public long getDt() {
    return dt;
  }

  public void setDt(long dt) {
    this.dt = dt;
  }

  @Override
  public String toString() {
    return "WeatherList{" + "dt=" + dt + ", dt_txt=" + dt_txt + ", main=" + main
        + ", clouds=" + clouds + '}';
  }

}
