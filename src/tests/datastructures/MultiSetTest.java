package tests.datastructures;

import org.junit.Test;
import weapon.datastructures.MultiSet;

import static junit.framework.TestCase.assertEquals;

public class MultiSetTest {

  @Test
  public void testReturnZero() {
    MultiSet<Integer> ms = new MultiSet<Integer>();
    assertEquals(0, ms.count(123));
  }
}
