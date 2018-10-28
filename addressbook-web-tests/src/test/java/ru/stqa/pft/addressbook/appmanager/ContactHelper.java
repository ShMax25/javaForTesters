package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstName() );
    type(By.name("lastname"),contactData.getLastName());
    type(By.name("nickname"),contactData.getUserName());
    type(By.name("title"),contactData.getTitleName());
    type(By.name("company"),contactData.getCompany());
    type(By.name("address"),contactData.getAddress());
    type(By.name("mobile"),contactData.getMobile());
    type(By.name("work"),contactData.getWorkNumber());
    type(By.name("email"),contactData.getEmail());
  }

  public void submitContactForm() {
    click(By.xpath("//input[@name='submit'][2]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }
}
