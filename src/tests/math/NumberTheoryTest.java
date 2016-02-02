package tests.math;

import org.junit.Test;
import weapon.math.NumberTheory;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by whhone on 2/2/16.
 */
public class NumberTheoryTest {

  @Test
  public void test() {
    Integer x = 0, y = 0;
    NumberTheory.egcd(3, 4, x, y);
    assertEquals(Integer.valueOf(10), x);
  }
}
