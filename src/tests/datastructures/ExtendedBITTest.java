package tests.datastructures;

import org.junit.Test;
import weapon.datastructures.ExtendedBIT;

import static junit.framework.TestCase.assertEquals;

public class ExtendedBITTest {

  @Test
  public void test() {
    ExtendedBIT exbit = new ExtendedBIT(100);
    exbit.add(5, 10, 10);
    assertEquals(10, exbit.query(5, 5));
    assertEquals(20, exbit.query(5, 6));

    exbit.add(7, 15, 5);
    assertEquals(10, exbit.query(5, 5));
    assertEquals(20, exbit.query(5, 6));
    assertEquals(35, exbit.query(5, 7));
    assertEquals(60 + 45, exbit.query(0, 15));

    exbit.add(0, 0, 10);
    assertEquals(10, exbit.query(0, 0));
    assertEquals(10, exbit.query(0, 1));
    assertEquals(10, exbit.query(0, 2));

    exbit.add(0, 2, 5);
    assertEquals(15, exbit.query(0, 0));
    assertEquals(20, exbit.query(0, 1));
    assertEquals(25, exbit.query(0, 2));
  }

  @Test
  public void testPOJ3468() {
    ExtendedBIT exbit = new ExtendedBIT(10);
    for (int i = 0; i < 10; i++) {
      exbit.add(i, i, i + 1);
    }
    assertEquals(4, exbit.query(3, 3));
    assertEquals(55, exbit.query(0, 9));
    assertEquals(9, exbit.query(1, 3));
    exbit.add(2, 5, 3);
    assertEquals(15, exbit.query(1, 3));
  }
}
