package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("Max")
              .withLastName("Sma")
              .withGroup("[none]"), true);
    }
  }


  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Frank45").withLastName("Lampard").withHomeNumber("77777").withWorkNumber("878273917").withMobile("78917397").withGroup("[none]");
    app.contact().modify(contact);
    assertEquals(app.contact().count() ,before.size());
    Contacts after = app.contact().all();

    assertThat(after,equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}

