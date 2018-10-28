package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.Test;

public class GroupDeleteionTests extends TestBase{

  @Test
  public void testGroupDeleteionTests() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}
