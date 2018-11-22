package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("test1");
    app.group().create(group);
    Set<GroupData> after = app.group().all();

    Assert.assertEquals(after.size(), before.size()+1 );

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()); // obiekt preobretaet znacenie grupi s naibolishim id
    before.add(group);//v mnojestvo dobavliaetsia sozdannaia gruppa
    Assert.assertEquals(before, after); // preobrazuem spisok v mnojestva
  }


}
