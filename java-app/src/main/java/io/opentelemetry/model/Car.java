package io.opentelemetry.model;

public class Car {

  private final int year;
  private final String make;
  private final String model;
  private final String color;

  public Car(int year, String make, String model, String color) {
    this.year = year;
    this.make = make;
    this.model = model;
    this.color = color;
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
}
