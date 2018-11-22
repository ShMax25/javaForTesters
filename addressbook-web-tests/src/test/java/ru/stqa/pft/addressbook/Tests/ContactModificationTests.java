package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("Max")
              .withLastName("Sma")
              .withGroup("[none]"), true);
    }
  }


  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Frank45").withLastName("Lampard").withWorkNumber("878273917").withMobile("78917397").withGroup("[none]");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();

    Assert.assertEquals(before.size(), after.size());

    before.remove(modifiedContact);
    before.add(contact);

    Assert.assertEquals(before, after);

  }
}

