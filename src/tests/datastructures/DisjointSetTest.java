package tests.datastructures;

import org.junit.Test;
import weapon.datastructures.DisjointSet;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;

public class DisjointSetTest {

  @Test
  public void test() {
    DisjointSet ds = new DisjointSet(6);
    for (int i = 0; i < 6; i++) {
      assertEquals(i, ds.find(i));
    }

    ds.union(0, 1);
    ds.union(2, 3);
    assertEquals(ds.find(1), ds.find(0));
    assertEquals(ds.find(2), ds.find(3));
    assertNotSame(ds.find(1), ds.find(2));

    ds.union(1, 2);
    assertEquals(ds.find(1), ds.find(0));
    assertEquals(ds.find(2), ds.find(3));
    assertEquals(ds.find(1), ds.find(2));
    assertEquals(4, ds.find(4));
  }
}
