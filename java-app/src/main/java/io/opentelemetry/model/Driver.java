package io.opentelemetry.model;

public class Driver {

  private final String firstName;
  private final String lastName;
  private final int age;
  private final String url;
//  private final int convictions;

  public Driver(String firstName, String lastName, int age, String url) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.url = url;
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

  public String getUrl() {
    return url;
  }
}
