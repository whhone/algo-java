package tests.geom;

import org.junit.Test;
import weapon.geom.Point;
import weapon.geom.Segment;

import static junit.framework.TestCase.assertEquals;

public class SegmentTest {

  @Test
  public void testIntersection() {
    Segment segment1 = new Segment(-10, -10, 10, 10);
    Segment segment2 = new Segment(-10, -10, 0, 10);
    Point i = segment1.intersect(segment2);
    assertEquals(new Point(-10, -10), i);
  }

  @Test
  public void testIntersection2() {
    Segment segment1 = new Segment(-10, -10, 10, 10);
    Segment segment2 = new Segment(0, -10, 0, 10);
    Point i = segment1.intersect(segment2);
    assertEquals(Point.ORIGIN, i);
  }

  @Test
  public void testIntersection3() {
    Segment segment1 = new Segment(-10, -10, 10, 10);
    Segment segment2 = new Segment(10, 10, 123, -143);
    Point i = segment1.intersect(segment2);
    assertEquals(new Point(10, 10), i);
  }
}
