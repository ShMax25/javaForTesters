package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String userName;
  private final String address;
  private final String mobile;
  private final String workNumber;
  private String group;

  public ContactData(String firstName, String lastName, String userName, String address, String mobile, String workNumber, String group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.address = address;
    this.mobile = mobile;
    this.workNumber = workNumber;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUserName() {
    return userName;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWorkNumber() {
    return workNumber;
  }

  public String getGroup() {
    return group;
  }
}
