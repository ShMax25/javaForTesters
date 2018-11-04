package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion () {
    app.getNavigationHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Pupkin", "QA", "Google", "2101 Signal Drive", "Google", "2101 Signal Dr", "65000333", "6509998888", "vpupkin@gmail.com", "test4"));
      return;
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().acceptContactDeletion();
    app.getContactHelper().returnToHomePage();
  }

}
