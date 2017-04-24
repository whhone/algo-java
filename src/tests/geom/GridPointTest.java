package tests.geom;

import org.junit.Test;
import weapon.geom.GridPoint;

import static junit.framework.TestCase.assertEquals;

public class GridPointTest {

  @Test
  public void testRotate90Clockwise() {
    GridPoint point34 = new GridPoint(3, 4);
    assertEquals(new GridPoint(4, -3), point34.rotate90Clockwise(GridPoint.ORIGIN));

    GridPoint point45 = new GridPoint(4, 5);
    assertEquals(new GridPoint(5, -2), point45.rotate90Clockwise(new GridPoint(1, 1)));
  }

  @Test
  public void testRotate90CounterClockwise() {
    GridPoint point34 = new GridPoint(3, 4);
    assertEquals(new GridPoint(-4, 3), point34.rotate90CounterClockwise(GridPoint.ORIGIN));

    GridPoint point45 = new GridPoint(4, 5);
    assertEquals(new GridPoint(-3, 4), point45.rotate90CounterClockwise(new GridPoint(1, 1)));
  }
}
