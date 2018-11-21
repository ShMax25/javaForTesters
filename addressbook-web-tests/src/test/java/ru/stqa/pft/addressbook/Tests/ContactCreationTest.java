package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {
    app.goTo().goToHomePage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstName("Ivam").withLastName("Groznii").withUserName("IG").withMobile("23424223").withAddress("2345 Sho dr").withGroup("[none]");
    app.contact().create(contact, true);
    List<ContactData> after = app.contact().list();

    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}
