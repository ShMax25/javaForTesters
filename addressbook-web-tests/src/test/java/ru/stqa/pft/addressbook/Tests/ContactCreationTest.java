package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testNewContactCreation() throws Exception {
    app.getNavigationHelper().goToHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact((new ContactData("Pupkin", "QA", "Google", "2101 Signal Drive", "65000333", "6509998888",  "[none]")), true);
    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
