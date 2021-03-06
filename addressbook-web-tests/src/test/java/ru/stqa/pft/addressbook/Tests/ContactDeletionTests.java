package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().goToHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstName("Alex")
              .withLastName("Last")
              .withHomeNumber("12313123")
              .withMobile("9829734973942")
              .withAddress("Drive road")
              .withGroup("[none]"), true);
    }
  }

  @Test
  public void testContactDeletion () {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.contact().returnToHomePage();
    Assert.assertEquals(app.contact().count(), before.size()-1 );
    Contacts after = app.contact().all();

    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
