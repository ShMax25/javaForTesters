package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;
import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstName;
  @Expose
  private String lastName;
  @Expose
  private String userName;
  @Expose
  private String address;
  @Expose
  private String home;
  @Expose
  private String mobile;
  @Expose
  private String workNumber;
  @Expose
  private String group;
  @Expose
  private String allPhones;
  @Expose
  private String email;
  @Expose
  private String email2;
  @Expose
  private String email3;
  @Expose
  private String allEmails;
  @Expose
  private File photo; // added new parameter for Contact Data


  public int getId() {
    return id;
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

  public String getHomeNumber() {
    return home;
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

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public File getPhoto() {
    return photo;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomeNumber(String home) {
    this.home = home;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWorkNumber(String workNumber) {
    this.workNumber = workNumber;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, firstName, lastName);
  }
}
