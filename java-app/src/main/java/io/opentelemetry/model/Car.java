package io.opentelemetry.model;

public class Car {

  private final int year;
  private final String make;
  private final String model;

  public Car(int year, String make, String model) {
    this.year = year;
    this.make = make;
    this.model = model;
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
}
