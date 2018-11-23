package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getUserName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomeNumber());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWorkNumber());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail());
    type(By.name("email3"), contactData.getEmail());

// Checks what test is it, do we need to check if element present or not
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void submitContactForm() {
    click(By.xpath("//input[@name='submit'][2]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void acceptContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int index) {
    wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id="+ id +"']")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void initAddNewContact() {
    click(By.linkText("add new"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact, boolean groupDropbox) {
    initAddNewContact();
    fillContactForm(contact, groupDropbox);
    submitContactForm();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(int index, ContactData contact) {
    initContactModification(index);
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete() {
    selectContact();
    deleteSelectedContact();
    acceptContactDeletion();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    contactCache = null;
    acceptContactDeletion();
  }

  public int count() {
   return wd.findElements(By.name("selected[]")).size();
  }

//  public List<ContactData> list() {
//    List<ContactData> contacts = new ArrayList<ContactData>();
//    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
//
//    for (WebElement element : elements) {
//      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
//      String name = element.findElement(By.xpath("./td[3]")).getText();
//      String lastName = element.findElement(By.xpath("./td[2]")).getText();
//      ContactData contact = new ContactData().withId(id).withFirstName(name).withLastName(lastName);
//      contacts.add(contact);
//    }
//  return contacts;
//  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String name = element.findElement(By.xpath("./td[3]")).getText();
      String lastName = element.findElement(By.xpath("./td[2]")).getText();
      String allPhones = element.findElement(By.xpath("./td[6]")).getText(); // poluciaem vse nomera srazu ne razdelino v vide odnoi stroki
      String address = element.findElement(By.xpath("./td[4]")).getText();
      String allEmails = element.findElement(By.xpath("./td[5]")).getText(); // poluciaem vse email srazu v vide odnoi stroki
      ContactData contact = new ContactData().withId(id).withFirstName(name).withLastName(lastName).withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails);
      contactCache.add(contact);
    }
    return contactCache;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstName(firstName)
            .withLastName(lastName)
            .withHomeNumber(home)
            .withMobile(mobile)
            .withWorkNumber(work)
            .withAddress(address)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3);
  }
}
