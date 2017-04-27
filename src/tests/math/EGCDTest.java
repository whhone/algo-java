package tests.math;

import org.junit.Test;
import weapon.math.EGCD;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class EGCDTest {

  private void assertEgcd(long a, long b, long expectedGCD) {
    EGCD egcd = new EGCD(a, b);
    assertTrue(egcd.getGcd() > 0);
    assertEquals(expectedGCD, egcd.getGcd());
    assertEquals(egcd.getGcd(), egcd.getX() * a + egcd.getY() * b);
  }

  @Test
  public void test() {
    assertEgcd(3, 4, 1);
    assertEgcd(3, 6, 3);
    assertEgcd(16, 24, 8);
    assertEgcd(123, 321, 3);
    assertEgcd(123, 0, 123);
    assertEgcd(0, 456, 456);

    assertEgcd(-123, 123, 123);
    assertEgcd(123, -123, 123);
  }
}
