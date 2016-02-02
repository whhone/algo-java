package tests.math;

import org.junit.Test;
import weapon.math.Nim;

import static junit.framework.TestCase.assertEquals;

public class NimTest {

  void assertMul(int x, int y, int expected) {
    assertEquals(String.format("%d %d %d\n", x, y, expected), expected, Nim.mul(x, y));
  }

  @Test
  public void testMul() {
    for (int i = 0; i < 50; i++) {
      assertMul(0, i, 0);
    }
    for (int i = 0; i < 50; i++) {
      assertMul(1, i, i);
    }
    for (int i = 0; i < 50; i++) {
      assertMul(i, 1, i);
    }

    assertMul(2, 2, 3);
    assertMul(2, 3, 1);
    assertMul(2, 4, 8);
    assertMul(2, 5, 10);
    assertMul(2, 6, 11);
    assertMul(2, 7, 9);
    assertMul(2, 8, 12);
    assertMul(2, 9, 14);

    assertMul(3, 1, 3);
    assertMul(3, 3, 2);
    assertMul(3, 4, 12);
    assertMul(4, 5, 2);
    assertMul(4, 6, 14);
    assertMul(5, 7, 13);
    assertMul(6, 8, 7);
    assertMul(7, 9, 8);
  }
}
