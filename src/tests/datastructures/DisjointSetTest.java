package tests.datastructures;

import org.junit.Test;
import weapon.datastructures.DisjointSet;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DisjointSetTest {

  @Test
  public void test() {
    DisjointSet ds = new DisjointSet(6);
    for (int i = 0; i < 6; i++) {
      assertEquals(i, ds.findSet(i));
    }

    ds.union(0, 1);
    ds.union(2, 3);
    assertTrue(ds.isSameSet(0, 1));
    assertTrue(ds.isSameSet(2, 3));
    assertFalse(ds.isSameSet(1, 2));

    ds.union(1, 2);
    assertTrue(ds.isSameSet(0, 1));
    assertTrue(ds.isSameSet(2, 3));
    assertTrue(ds.isSameSet(1, 2));
    assertEquals(4, ds.findSet(4));
  }
}
