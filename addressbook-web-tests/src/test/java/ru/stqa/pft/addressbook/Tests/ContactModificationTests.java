package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Max").withLastName("Sma").withGroup("[none]"), true);
    }
    List<ContactData> before = app.contact().list();
    int index = before.size() - 2;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstName("Frank").withLastName("Lampard").withWorkNumber("878273917").withMobile("78917397").withGroup("[none]");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();

    Assert.assertEquals(before.size(), after.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);

  }
}

