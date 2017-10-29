package com.warszawa.prognoza;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
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

public class WeatherFacade implements Serializable {
  private WeatherGeneral weatherGeneral;
  private List<Date> hours;
  private List<Double> temp;
  private List<Double> pressure;
  private List<Double> humidity;
  private List<Integer> clouds;
  private double cod;
  public WeatherFacade() throws MalformedURLException, IOException {
    hours = new ArrayList();
    temp = new ArrayList<>();
    pressure = new ArrayList<>();
    humidity = new ArrayList<>();
    clouds = new ArrayList<>();
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    // Gson gson =new Gson();
    URL url = new URL(
        "http://api.openweathermap.org/data/2.5/forecast?lat=52.23&lon=21.01&units=metric&appid=6cf7743e84d7bb3c43ae15fc4e51a8b6");
    BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));
    weatherGeneral = gson.fromJson(in, WeatherGeneral.class);
  }

  public List<Integer> getClouds() {
    List<WeatherList> list = weatherGeneral.getList();
    for (WeatherList weatherList : list) {
      WeatherClouds clouds = weatherList.getClouds();
      this.clouds.add(clouds.getAll());
    }
    return clouds;
  }

  public void setClouds(List<Integer> clouds) {
    this.clouds = clouds;
  }

  public List<Date> getHours() {
    List<WeatherList> list = weatherGeneral.getList();
    for (WeatherList weatherList : list) {
      Date hour = weatherList.getDt_txt();
      this.hours.add(hour);
    }
    return hours;
  }

  public void setHours(List<Date> hours) {
    this.hours = hours;
  }

  public List<Double> getTemp() {
    List<WeatherList> list = weatherGeneral.getList();
    for (WeatherList weatherList : list) {
      WeatherMain main = weatherList.getMain();
      Double temp2 = main.getTemp();
      this.temp.add(temp2);
    }
    return temp;
  }

  public List<Double> getPressure() {
    List<WeatherList> list = weatherGeneral.getList();
    for (WeatherList weatherList : list) {
      WeatherMain main = weatherList.getMain();
      Double temp2 = main.getPressure();
      this.pressure.add(temp2);
    }
    return pressure;
  }

  public void setPressure(List<Double> pressure) {
    this.pressure = pressure;
  }

  public List<Double> getHumidity() {
    List<WeatherList> list = weatherGeneral.getList();
    for (WeatherList weatherList : list) {
      WeatherMain main = weatherList.getMain();
      Double humidity2 = main.getHumidity();
      this.humidity.add(humidity2);
    }
    return humidity;
  }

  public void setHumidity(List<Double> humidity) {
    this.humidity = humidity;
  }

  public void setTemp(List<Double> temp) {
    this.temp = temp;
  }

  public double getCod() {
    return weatherGeneral.getCod();
  }

  public void setCod(double cod) {
    this.cod = cod;
  }

  public WeatherGeneral getWeatherGeneral() {
    return weatherGeneral;
  }

  public void setWeatherGeneral(WeatherGeneral weatherGeneral) {
    this.weatherGeneral = weatherGeneral;
  }
  public int getMinTemp() {
    getHours();
    double min = Collections.min(temp);
    return (int) min;
  }
  public int getMaxTemp() {
    getHours();
    double max = Collections.max(temp);
    return (int) max;
  }
  public int getMinPressure() {
    getPressure();
    double min = Collections.min(pressure);
    return (int) min;
  }
  public int getMaxPressure() {
    getPressure();
    double max = Collections.max(pressure);
    return (int) max;
  }
  public String getMinDate() {
    getHours();
    Date date = Collections.min(hours);
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 1);
    Date todate1 = cal.getTime();
    return todate1.toGMTString();
  }
  public String getMaxDate() {
    getHours();
    Date date = Collections.max(hours);

    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
    Date todate1 = cal.getTime();
    return todate1.toGMTString();
  }

  @Override
  public String toString() {
    return "WeatherFacade{" + "weatherGeneral=" + weatherGeneral + ", hours="
        + hours + ", temp=" + temp + ", pressure=" + pressure + ", cod=" + cod
        + "!1!" + weatherGeneral.toString() + '}';
  }

}
