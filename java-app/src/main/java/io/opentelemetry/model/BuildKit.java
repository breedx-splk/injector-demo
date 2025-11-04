package io.opentelemetry.model;

public class BuildKit {

  private final Car car;
  private final Driver driver;
  //TODO: Mabe add a little fake film narrative for funzies.

  public BuildKit(Car car, Driver driver) {
    this.car = car;
    this.driver = driver;
  }

  public Car getCar() {
    return car;
  }

  public Driver getDriver() {
    return driver;
  }
}
