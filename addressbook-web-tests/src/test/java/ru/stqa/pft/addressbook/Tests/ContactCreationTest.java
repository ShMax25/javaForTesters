package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {
    app.goTo().goToHomePage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Ivam").withLastName("Groznii").withUserName("IG").withMobile("23424223").withAddress("2345 Sho dr").withGroup("[none]");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();

    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);
  }
}
