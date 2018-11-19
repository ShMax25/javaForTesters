package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions (){
    app.goTo().groupPage();
    if (! app.group().isThereAGroup()) {
      app.group().create(new GroupData("test1", null, null));
    }
  }


  @Test
  public void testGroupDeletionTests() throws Exception {
    List<GroupData> before = app.group().list();
    app.group().selectGroup(before.size() -1);
    app.group().deleteSelectedGroups();
    app.group().returnToGroupPage();
    List<GroupData> after = app.group().list();

    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(before.size() -1);
    Assert.assertEquals(before, after);

  }

}
