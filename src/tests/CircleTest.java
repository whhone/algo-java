package tests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import weapon.geom.Circle;
import weapon.geom.Line;
import weapon.geom.Point;

import java.util.List;

public class CircleTest {

  @Test
  public void testFoo() {
    Point point = new Point(3, 4);
    assertEquals(5, point.distance(Point.ORIGIN), 1e-8);
  }

  @Test
  public void testCircleTwoIntersections() {
    Circle ca = new Circle(new Point(+10, 0), 20);
    Circle cb = new Circle(new Point(-10, 0), 20);
    List<Point> intersections = ca.intersect(cb);
    assertEquals(2, intersections.size());
    Point p0 = intersections.get(0);
    Point p1 = intersections.get(1);
    assertEquals(new Point(0, Math.sqrt(300)), p0);
    assertEquals(new Point(0, -Math.sqrt(300)), p1);
  }

  @Test
  public void testCircleOneIntersections() {
    Circle ca = new Circle(new Point(+10, 0), 10);
    Circle cb = new Circle(new Point(-10, 0), 10);
    List<Point> intersections = ca.intersect(cb);
    assertEquals(1, intersections.size());
    Point p0 = intersections.get(0);
    assertEquals(new Point(0, 0), p0);
  }

  @Test
  public void testCircleNoIntersections() {
    Circle ca = new Circle(new Point(+10, 0), 9.9);
    Circle cb = new Circle(new Point(-10, 0), 10);
    List<Point> intersections = ca.intersect(cb);
    assertEquals(0, intersections.size());
  }

  @Test
  public void testLineTwoIntersectionsViaCenter() {
    Circle ca = new Circle(new Point(0, 0), 10);
    Line line = new Line(Point.ORIGIN, Point.ORIGIN.move(1, 1));
    List<Point> intersections = ca.intersect(line);
    assertEquals(2, intersections.size());
    Point p0 = intersections.get(0);
    Point p1 = intersections.get(1);
    assertEquals(new Point(10 / Math.sqrt(2), 10 / Math.sqrt(2)), p0);
    assertEquals(new Point(-10 / Math.sqrt(2), -10 / Math.sqrt(2)), p1);
  }

  @Test
  public void testLineTwoIntersections() {
    Circle ca = new Circle(new Point(0, 0), 10);
    Line line = new Line(10, 0, 0, 10);
    List<Point> intersections = ca.intersect(line);
    assertEquals(2, intersections.size());
    Point p0 = intersections.get(0);
    Point p1 = intersections.get(1);
    assertEquals(new Point(10, 0), p0);
    assertEquals(new Point(0, 10), p1);
  }

  @Test
  public void testCircleLineOneIntersections() {
    Circle ca = new Circle(new Point(10, 10), 10);
    Line line = new Line(Point.ORIGIN, Point.ORIGIN.move(0, 1));
    List<Point> intersections = ca.intersect(line);
    assertEquals(1, intersections.size());
    Point p0 = intersections.get(0);
    assertEquals(new Point(0, 10), p0);
  }

  @Test
  public void testCircleLineNoIntersections() {
    Circle ca = new Circle(new Point(10, 10), 9.999);
    Line line = new Line(Point.ORIGIN, Point.ORIGIN.move(0, 1));
    List<Point> intersections = ca.intersect(line);
    assertEquals(0, intersections.size());
  }
}
