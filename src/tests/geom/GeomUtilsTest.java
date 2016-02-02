package tests.geom;

import org.junit.Test;
import weapon.geom.GeomUtils;

import static junit.framework.TestCase.assertEquals;

public class GeomUtilsTest {

  @Test
  public void testDotProduct() {
    assertEquals(100, GeomUtils.dotProduct(10, 0, 0, 10, 0, 0), 1e-8);
    assertEquals(-100, GeomUtils.dotProduct(10, 0, 0, -10, 0, 0), 1e-8);
    assertEquals(0, GeomUtils.dotProduct(10, 0, 10, 0, 0, 0), 1e-8);
  }
}
