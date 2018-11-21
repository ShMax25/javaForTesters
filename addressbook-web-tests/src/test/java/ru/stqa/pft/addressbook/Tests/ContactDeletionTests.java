package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion () {
    app.goTo().goToHomePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Alex").withLastName("Last").withMobile("9829734973942").withAddress("Drive road").withGroup("[none]"), true);
    }
    List<ContactData> before = app.contact().list();
    app.contact().delete();
    app.contact().returnToHomePage();
    List<ContactData> after = app.contact().list();


    Assert.assertEquals(after.size(), before.size()-1 );
  }

}
