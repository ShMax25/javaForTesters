package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test (enabled = false)
  public void testContactModification() {
    if (app.contact().getContactList().size() == 0) {
      app.contact().create(new ContactData("Max", "Sma", null , null, null, null,  "[none]"), true);
    }
    List<ContactData> before = app.contact().getContactList();
    int index = before.size() - 2;
    ContactData contact = new ContactData(before.get(index).getId(), "John", "Travolta", "JT", "222 jasdjsa", "89498310813", "1323123123", "[none]");
    app.contact().initContactModification(index);
    app.contact().modify(contact, false);
    app.contact().submitContactModification();
    app.contact().returnToHomePage();
    List<ContactData> after = app.contact().getContactList();

    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);

  }
}

