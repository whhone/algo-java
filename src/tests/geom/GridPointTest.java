package tests.geom;

import org.junit.Test;
import weapon.geom.GridPoint;

import static junit.framework.TestCase.assertEquals;

public class GridPointTest {

  @Test
  public void testRotate90Clockwise() {
    GridPoint point = new GridPoint(3, 4);
    assertEquals(new GridPoint(4, -3), point.rotate90Clockwise(GridPoint.ORIGIN));
  }

  @Test
  public void testRotate90Clockwise2() {
    GridPoint point = new GridPoint(4, 5);
    assertEquals(new GridPoint(5, -2), point.rotate90Clockwise(new GridPoint(1, 1)));
  }
}
