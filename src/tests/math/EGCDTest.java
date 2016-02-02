package tests.math;

import org.junit.Test;
import weapon.math.EGCD;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by whhone on 2/2/16.
 */
public class EGCDTest {

  private void assertEgcd(long a, long b, long expectedGCD, long expectedX, long expectedY) {
    EGCD egcd = new EGCD(a, b);
    assertEquals(expectedGCD, egcd.gcd);
    assertEquals(expectedX, egcd.x);
    assertEquals(expectedY, egcd.y);
    assertEquals(egcd.gcd, egcd.x * a + egcd.y * b);
  }

  @Test
  public void test() {
    assertEgcd(3, 4, 1, -1, 1);
    assertEgcd(3, 6, 3, 1, 0);
    assertEgcd(16, 24, 8, -1, 1);
    assertEgcd(123, 321, 3, 47, -18);
  }
}
