package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {
    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().getContactsCount();
    app.getContactHelper().createContact((new ContactData("Pupkin", "QA", "Google", "2101 Signal Drive", "Google", "2101 Signal Dr", "65000333", "6509998888", "vpupkin@gmail.com", "[none]")), true);
    int after = app.getContactHelper().getContactsCount();

    Assert.assertEquals(after, before + 1);
  }
}
