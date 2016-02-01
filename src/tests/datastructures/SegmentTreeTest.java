package tests.datastructures;

import org.junit.Before;
import org.junit.Test;
import weapon.datastructures.SegmentTree;

import static junit.framework.TestCase.assertEquals;

public class SegmentTreeTest {

  SegmentTree smt;

  @Before
  public void setUp() {
    smt = new SegmentTree(Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  @Test
  public void testBasic() {
    assertEquals(0, smt.query(-1000000, 1000000));

    smt.add(10, 10);
    assertEquals(10, smt.query(-1000000, 1000000));

    smt.add(15, 15);
    assertEquals(25, smt.query(-1000000, 1000000));

    smt.add(16, 16);
    assertEquals(16, smt.query(16, 16));
    assertEquals(41, smt.query(-1000000, 1000000));

    smt.add(15, -15);
    assertEquals(26, smt.query(-1000000, 1000000));
    assertEquals(10, smt.query(10, 15));

    assertEquals(26, smt.query(Integer.MIN_VALUE, Integer.MAX_VALUE));
  }
}
