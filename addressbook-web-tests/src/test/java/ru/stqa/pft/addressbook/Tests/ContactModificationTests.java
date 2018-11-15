package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Max", "Sma", null , null, null, null,  "[none]"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification(before.size() -2);
    app.getContactHelper().fillContactForm(new ContactData(before.get(before.size()-2).getId(),"Ivan", "Wolf", "WQ", "2211 jjikol", "8907986", "6876875746", "[none]"), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(before.size(), after.size());

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }
}

