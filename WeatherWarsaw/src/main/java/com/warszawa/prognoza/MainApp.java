package com.warszawa.prognoza;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    stage.setTitle("Prognoza Pogody Warszawa");
    WeatherFacade wf = new WeatherFacade();
    List<Double> tempData = wf.getTemp();
    List<Double> pressureData = wf.getPressure();
    List<Double> humidityData = wf.getHumidity();
    List<Integer> cloudsData = wf.getClouds();
    List<Date> hoursData = wf.getHours();

    final CategoryAxis dateAxis = new CategoryAxis();
    final NumberAxis tempAxis = new NumberAxis(wf.getMinTemp() - 3,
        wf.getMaxTemp() + 3, 1);
    final LineChart<String, Number> tempChart = new LineChart<String, Number>(
        dateAxis, tempAxis);
    tempChart.setTitle("Temperatura");
    final CategoryAxis dateAxis2 = new CategoryAxis();
    dateAxis2.setTickLabelRotation(33);
    final NumberAxis pressureAxis = new NumberAxis(wf.getMinPressure() - 10,
        wf.getMaxPressure() + 10, 5);
    pressureAxis.setTickLabelRotation(33);
    final LineChart<String, Number> pressureChart = new LineChart<String, Number>(
        dateAxis2, pressureAxis);
    pressureChart.setTitle("Ciśnienie");

    final CategoryAxis dateAxis3 = new CategoryAxis();
    final NumberAxis humidityAxis3 = new NumberAxis();
    final BarChart<String, Number> humidityChart = new BarChart<String, Number>(
        dateAxis3, humidityAxis3);
    humidityChart.setTitle("Wilgotność");

    final CategoryAxis dateAxis4 = new CategoryAxis();
    final NumberAxis cloudsAxis = new NumberAxis(0, 100, 20);

    final BarChart<String, Number> cloudsChart = new BarChart<String, Number>(
        dateAxis4, cloudsAxis);
    cloudsChart.setTitle("Zachmurzenie");

    dateAxis4.setTickLabelRotation(60);

    XYChart.Series tempSeries = new XYChart.Series();
    tempSeries.setName("Temperatura");
    XYChart.Series pressureSeries = new XYChart.Series();
    pressureSeries.setName("Ciśnienie");
    XYChart.Series humiditySeries = new XYChart.Series();
    humiditySeries.setName("Wilgotność");
    XYChart.Series cloudsSeries = new XYChart.Series();
    cloudsSeries.setName("Zachmurzenie");

    for (int i = 0; i < tempData.size(); i++) {
      SimpleDateFormat dt = new SimpleDateFormat("dd-MM HH");
      Date dt2 = hoursData.get(i);
      tempSeries.getData()
          .add(new XYChart.Data(dt.format(dt2) + "H", tempData.get(i)));
      cloudsSeries.getData()
          .add(new XYChart.Data(dt.format(dt2) + "H", cloudsData.get(i)));
    }
    for (int i = 0; i < tempData.size(); i = i + 5) {
      if (i >= pressureData.size())
        break;
      SimpleDateFormat dt = new SimpleDateFormat("dd-MM HH");
      Date dt2 = hoursData.get(i);
      pressureSeries.getData()
          .add(new XYChart.Data(dt.format(dt2) + "H", pressureData.get(i)));
    }
    for (int i = 0; i < tempData.size(); i = i + 3) {
      if (i >= pressureData.size())
        break;
      SimpleDateFormat dt = new SimpleDateFormat("dd-MM HH");
      Date dt2 = hoursData.get(i);
      humiditySeries.getData()
          .add(new XYChart.Data(dt.format(dt2) + "H", humidityData.get(i)));
    }
    tempChart.getData().addAll(tempSeries);
    pressureChart.getData().addAll(pressureSeries);
    humidityChart.getData().addAll(humiditySeries);
    cloudsChart.getData().addAll(cloudsSeries);
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(0, 10, 0, 10));
    Label label = new Label("PROGNOZA POGODY WARSZAWA");
    tempChart.setStyle("CHART_COLOR_1: blue;");
    pressureChart.setStyle("CHART_COLOR_1: red;");
    humidityChart.setStyle("CHART_COLOR_1: green;");
    cloudsChart.setStyle("CHART_COLOR_1: blue;");
    grid.add(tempChart, 1, 1);
    grid.add(pressureChart, 2, 1);
    grid.add(humidityChart, 1, 2);
    grid.add(cloudsChart, 2, 2);

    Scene scene = new Scene(grid, 950, 780);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
