package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {
    app.getNavigationHelper().initAddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Pupkin", "QA", "Google", "2101 Signal Drive", "Google", "2101 Signal Dr", "65000333", "6509998888", "vpupkin@gmail.com", "test4"), true);
    app.getContactHelper().submitContactForm();
    app.getContactHelper().returnToHomePage();
  }
}
