package tests.datastructures;

import org.junit.Test;
import weapon.datastructures.MaxXorTree;

import static junit.framework.TestCase.assertEquals;

public class MaxXorTreeTest {

  @Test
  public void testMaxXorTree() {
    MaxXorTree mxt = new MaxXorTree(30);
    mxt.insert(0);
    mxt.insert(8);
    mxt.insert(9);
    mxt.insert(11);
    mxt.insert(6);
    mxt.insert(1);

    assertEquals(11, mxt.query(3) ^ 3);
    mxt.remove(8);
    assertEquals(10, mxt.query(3) ^ 3);
    assertEquals(14, mxt.query(8) ^ 8);
    assertEquals(13, mxt.query(11) ^ 11);
  }
}
