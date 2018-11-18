package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

  @Test (enabled = false)
  public void testContactDeletion () {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Alex","Pancho","SanchPAnch", "2113 oojjsa", "989879174", "12313123","[none]"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().acceptContactDeletion();
    List<ContactData> after = app.getContactHelper().getContactList();
    app.getContactHelper().returnToHomePage();

    Assert.assertEquals(after.size(), before.size()-1 );
  }

}
