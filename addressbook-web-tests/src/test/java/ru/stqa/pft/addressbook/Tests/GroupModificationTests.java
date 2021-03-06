package ru.stqa.pft.addressbook.Tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase{
  @BeforeMethod
  public void ensurePreconditions (){
    app.goTo().groupPage();
    if (app.group().list().size() == 0 ) {
      app.group().create(new GroupData().withName("test1"));
    }
  }


  @Test
  public void testGroupModification (){
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next(); // prisvaivaet znacenie sluciainoi gruppi
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withName("22test99").withHeader("test2")
            .withFooter("test3"); // dobavlen id modificirovannoi gruppi
    app.group().modify(group);
    assertEquals(app.group().count(),before.size());
    Groups after = app.group().all();

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

  }

}
