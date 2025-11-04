package io.opentelemetry.model;

public class Car {

  private final int year;
  private final String make;
  private final String model;
  private final String color;
  private final String url;

  public Car(int year, String make, String model, String color, String url) {
    this.year = year;
    this.make = make;
    this.model = model;
    this.color = color;
    this.url = url;
  }

  public int getYear() {
    return year;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public String getColor() {
    return color;
  }

  public String getUrl() {
    return url;
  }
}
