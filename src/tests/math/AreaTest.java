package tests.math;

import org.junit.Test;
import weapon.math.Area;

import static junit.framework.TestCase.assertEquals;

public class AreaTest {

  @Test
  public void regularPolygonForTriangles() {
    assertEquals(Math.sqrt(3) / 4, Area.ofRegularPolygon(3, 1), 1e-8);
    assertEquals(Math.sqrt(3), Area.ofRegularPolygon(3, 2), 1e-8);
    assertEquals(Math.sqrt(3) / 4 * 9, Area.ofRegularPolygon(3, 3), 1e-8);
  }

  @Test
  public void regularPolygonForSquares() {
    assertEquals(1, Area.ofRegularPolygon(4, 1), 1e-8);
    assertEquals(4, Area.ofRegularPolygon(4, 2), 1e-8);
    assertEquals(9, Area.ofRegularPolygon(4, 3), 1e-8);
  }

  @Test
  public void regularPolygonForPentagon() {
    assertEquals(1.720477400588967, Area.ofRegularPolygon(5, 1), 1e-8);
    assertEquals(6.881909602355868, Area.ofRegularPolygon(5, 2), 1e-8);
    assertEquals(15.484296605300703, Area.ofRegularPolygon(5, 3), 1e-8);
  }

  @Test
  public void triangle() {
    assertEquals(6, Area.ofTriangle(3, 4, 5), 1e-8);
    assertEquals(0, Area.ofTriangle(3, 4, 7), 1e-8);
  }

  @Test
  public void circle() {
    assertEquals(Math.PI, Area.ofCircle(1), 1e-8);
    assertEquals(Math.PI * 10000, Area.ofCircle(100), 1e-8);
  }

  @Test
  public void ellipse() {
    assertEquals(0, Area.ofEllipse(0, 0), 1e-8);
    assertEquals(Math.PI * 1 * 2, Area.ofEllipse(1, 2), 1e-8);
  }
}
