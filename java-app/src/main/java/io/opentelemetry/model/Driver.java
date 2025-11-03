package io.opentelemetry.model;

public class Driver {

  private final String firstName;
  private final String lastName;
  private final int age;
//  private final int convictions;

  public Driver(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }
}
