package io.opentelemetry.model;

public class BuildKit {

  private final Car car;
  private final String color;
  private final Driver driver;
  //TODO: Mabe add a little fake film narrative for funzies.

  public BuildKit(Car car, String color, Driver driver) {
    this.car = car;
    this.driver = driver;
    this.color = color;
  }

  public Car getCar() {
    return car;
  }

  public Driver getDriver() {
    return driver;
  }

  public String getColor() {
    return color;
  }
}
