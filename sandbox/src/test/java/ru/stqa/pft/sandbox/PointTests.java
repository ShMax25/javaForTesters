package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(1,2);
    Point p2 = new Point(5, 5);

    Assert.assertEquals(p1.distance(p2), 5.0);
  }

  @Test
  public  void testDistance2() {
    Point p1 = new Point(6,0);
    Point p2 = new Point(8, 0);

    Assert.assertEquals(p1.distance(p2), 2.0);
  }

  @Test
  public  void testDistance3() {
    Point p1 = new Point(0,0);
    Point p2 = new Point(6, 8);

    Assert.assertEquals(p1.distance(p2), 10.0);
  }

}
