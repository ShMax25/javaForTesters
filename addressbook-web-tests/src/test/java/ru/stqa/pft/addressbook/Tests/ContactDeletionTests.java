package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

  @Test (enabled = false)
  public void testContactDeletion () {
    app.goTo().goToHomePage();
    if (! app.contact().isThereAContact()) {
      app.contact().create(new ContactData("Alex","Pancho","SanchPAnch", "2113 oojjsa", "989879174", "12313123","[none]"), true);
    }
    List<ContactData> before = app.contact().getContactList();
    app.contact().selectContact();
    app.contact().deleteSelectedContact();
    app.contact().acceptContactDeletion();
    List<ContactData> after = app.contact().getContactList();
    app.contact().returnToHomePage();

    Assert.assertEquals(after.size(), before.size()-1 );
  }

}
