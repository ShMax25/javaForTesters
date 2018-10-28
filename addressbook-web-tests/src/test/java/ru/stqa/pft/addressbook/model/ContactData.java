package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String lastName;
  private final String userName;
  private final String titleName;
  private final String company;
  private final String address;
  private final String mobile;
  private final String workNumber;
  private final String email;

  public ContactData(String firstName, String lastName, String userName, String titleName, String company, String address, String mobile, String workNumber, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.titleName = titleName;
    this.company = company;
    this.address = address;
    this.mobile = mobile;
    this.workNumber = workNumber;
    this.email = email;
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

  public String getTitleName() {
    return titleName;
  }

  public String getCompany() {
    return company;
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

  public String getEmail() {
    return email;
  }
}
