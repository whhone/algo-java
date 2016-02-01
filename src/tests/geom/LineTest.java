package tests.geom;

import org.junit.Test;
import weapon.geom.Line;
import weapon.geom.Point;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class LineTest {

  @Test
  public void testHorizontalLine() {
    Line line1 = new Line(0, 1, 0);
    assertEquals(0, line1.getSlope(), 1e-8);
    assertEquals(200, line1.distance(new Point(100, 200)), 1e-8);

    Line line2 = new Line(0, 1, 1.5);
    assertEquals(0, line2.getSlope(), 1e-8);
    assertEquals(201.5, line2.distance(new Point(100, 200)), 1e-8);

    assertTrue(line1.isParallel(line2));
  }

  @Test
  public void testVerticalLine() {
    Line line1 = new Line(1, 0, 0);
    assertEquals(Double.POSITIVE_INFINITY, line1.getSlope(), 1e-8);
    assertEquals(100, line1.distance(new Point(100, 200)), 1e-8);

    Line line2 = new Line(1, 0, -3.5);
    assertEquals(Double.POSITIVE_INFINITY, line2.getSlope(), 1e-8);
    assertEquals(96.5, line2.distance(new Point(100, 200)), 1e-8);

    assertTrue(line1.isParallel(line2));
  }

  @Test
  public void testNormalLine() {
    Line line1 = new Line(123, 123, 0);
    assertEquals(-1, line1.getSlope(), 1e-8);
    assertEquals(100 * Math.sqrt(2), line1.distance(new Point(100, 100)), 1e-8);

    Line line2 = new Line(33, 33, -3.5);
    assertEquals(-1, line2.getSlope(), 1e-8);

    assertTrue(line1.isParallel(line2));
  }

  @Test
  public void testLineIntersect() {
    Line line1 = new Line(1, 0, 0);
    Line line2 = new Line(0, 1, 0);
    Point p = line1.intersect(line2);
    assertEquals(Point.ORIGIN, p);

    Line line3 = new Line(12, 34, 56);
    Line line4 = new Line(98, 76, 54);
    p = line3.intersect(line4);
    assertEquals(new Point(1, -2), p);
  }

  @Test
  public void testLineParallel() {
    Line line1 = new Line(1, 0, 0);
    Line line2 = new Line(0, 1, 0);
    assertFalse(line1.isParallel(line2));

    // Parallel line
    Line line3 = new Line(12, 34, 56);
    Line line4 = new Line(-24, -68, 54);
    assertTrue(line3.isParallel(line4));

    // Same line
    Line line5 = new Line(12, 34, 56);
    Line line6 = new Line(24, 68, 112);
    assertTrue(line5.isParallel(line6));

    Line line7 = new Line(1000000, 1000000, 0);
    Line line8 = new Line(1000000, 1000000.1, 0);
    assertFalse(line7.isParallel(line8));
  }

  @Test
  public void testEquals() {
    Line line1 = new Line(1, 0, 0);
    Line line2 = new Line(0, 1, 0);
    assertFalse(line1.equals(line2));

    Line line3 = new Line(12, 34, 56);
    Line line4 = new Line(-24, -68, -112);
    assertTrue(line3.equals(line4));
  }
}

