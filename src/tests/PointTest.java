package tests;

import org.junit.Test;
import weapon.geom.Line;
import weapon.geom.Point;
import weapon.geom.Segment;

import static junit.framework.TestCase.assertEquals;

public class PointTest {

  @Test
  public void testDistanceToPoint() {
    Point origin = Point.ORIGIN;
    assertEquals(10 * Math.sqrt(2),  origin.distance(10, 10), 1e-8);
  }

  @Test
  public void testDistanceToSegment() {
    Point point = new Point(10, 10);
    Point origin = Point.ORIGIN;

    Segment seg_0_20 = new Segment(0, 0, 20, 0);
    assertEquals(10, point.distance(seg_0_20), 1e-8);
    assertEquals(0, origin.distance(seg_0_20), 1e-8);

    Segment seg_10_30 = new Segment(10, 0, 30, 0);
    assertEquals(10, point.distance(seg_10_30), 1e-8);
    assertEquals(10, origin.distance(seg_10_30), 1e-8);

    Segment seg_20_40 = new Segment(20, 0, 40, 0);
    assertEquals(Math.sqrt(100 + 100), point.distance(seg_20_40), 1e-8);
    assertEquals(20, origin.distance(seg_20_40), 1e-8);
  }

  @Test
  public void testDistanceToLine() {
    Point point = new Point(10, 10);
    Point origin = Point.ORIGIN;

    Line line1 = new Line(10, 10, 8, 100);
    assertEquals(0, point.distance(line1), 1e-8);

    Line line2 = new Line(100, 0, 200, 0);
    assertEquals(10, point.distance(line2), 1e-8);
    assertEquals(0, origin.distance(line2), 1e-8);
  }

  @Test
  public void testRotateOnOrigin() {
    Point point = new Point(10, 0);
    Point p90 = point.rotate(Math.PI / 2);
    assertEquals(new Point(0, 10), p90);

    Point p180 = p90.rotate(Math.PI / 2);
    assertEquals(new Point(-10, 0), p180);

    Point p245 = p90.rotate(Math.PI / 4 * 3);
    assertEquals(new Point(-10 / Math.sqrt(2), -10 / Math.sqrt(2)), p245);

    Point p360 = p245.rotate(Math.PI / 4 * 3);
    assertEquals(point, p360);

    Point p540 = point.rotate(Math.PI * 3);
    assertEquals(p180, p540);
  }

  @Test
  public void testRotate() {
    Point o = new Point(10, 10);

    Point point = new Point(20, 10);
    Point p90 = point.rotate(o, Math.PI / 2);
    assertEquals(new Point(10, 20), p90);

    Point p180 = p90.rotate(o, Math.PI / 2);
    assertEquals(new Point(0, 10), p180);

    Point p245 = p90.rotate(o, Math.PI / 4 * 3);
    assertEquals(new Point(-10 / Math.sqrt(2) + 10, -10 / Math.sqrt(2) + 10), p245);

    Point p360 = p245.rotate(o, Math.PI / 4 * 3);
    assertEquals(point, p360);

    Point p540 = point.rotate(o, Math.PI * 3);
    assertEquals(p180, p540);
  }

  @Test
  public void testScale() {
    Point point = new Point(10, 20);

    Point p2 = point.scale(Point.ORIGIN, 2);
    assertEquals(new Point(20, 40), p2);

    Point p0 = point.scale(Point.ORIGIN, 0);
    assertEquals(new Point(0, 0), p0);
  }
}
