package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {
    app.goTo().goToHomePage();
    Contacts before = app.contact().all();
    File photo = new File ("src/test/resources/stru.png");
    ContactData contact = new ContactData()
            .withFirstName("Joni")
            .withLastName("Groznii")
            .withUserName("IG")
            .withHomeNumber("27492749234")
            .withMobile("23424223")
            .withAddress("2345 Sho dr")
            .withGroup("[none]")
            .withEmail("test@mail.co")
            .withEmail2("test2mail.co")
            .withEmail3("test3@mail.co")
            .withPhoto(photo);
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
