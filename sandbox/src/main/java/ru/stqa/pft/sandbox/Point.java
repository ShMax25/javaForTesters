package ru.stqa.pft.sandbox;

public class Point {

  public double x;
  public double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }


  public double distance (Point p){
   double result = (Math.sqrt((x - p.x)*(x - p.x)+(y - p.y)*(y - p.y)));
   return result;

  }

  public static void main (String[] args){
    Point p1 = new Point(4, 6);
    Point p2 = new Point(28,13);


    System.out.println(p1.distance(p2));
  }

}
