package tests.math;

import org.junit.Test;
import weapon.math.ChineseRemainderTheorem;

import static junit.framework.TestCase.assertEquals;

public class ChineseRemainderTheoremTest {

  @Test
  public void test() {
    long[] r = {1, 2, 3};
    long[] m = {3, 5, 7};
    long ans = ChineseRemainderTheorem.solveCoPrime(r, m);
    assertEquals(52, ans);
  }

  @Test
  public void test2() {
    long[] r = {2, 4, 6};
    long[] m = {3, 5, 7};
    long ans = ChineseRemainderTheorem.solveCoPrime(r, m);
    assertEquals(104, ans);
  }

  @Test
  public void test3() {
    long[] r = {1, 3, 19};
    long[] m = {4, 9, 25};
    long ans = ChineseRemainderTheorem.solveCoPrime(r, m);
    assertEquals(669, ans);
  }

  @Test
  public void test4() {
    long[] r = {123456789, 123456777};
    long[] m = {2000000000, 1999999999};
    long ans = ChineseRemainderTheorem.solveCoPrime(r, m);
    assertEquals(3999999974123456789L, ans);
  }

  @Test
  public void testMightNotCoPrime1() {
    long[] r = {1, 3, 19};
    long[] m = {4, 9, 25};
    long ans = ChineseRemainderTheorem.solveMightNotCoPrime(r, m);
    assertEquals(669, ans);
  }

  @Test
  public void testMightNotCoPrime2() {
    long[] r = {1, 3, 5};
    long[] m = {4, 6, 8};
    long ans = ChineseRemainderTheorem.solveMightNotCoPrime(r, m);
    assertEquals(21, ans);
  }

  @Test
  public void testMightNotCoPrime3() {
    long[] r = {1, 3, 1};
    long[] m = {4, 6, 9};
    long ans = ChineseRemainderTheorem.solveMightNotCoPrime(r, m);
    assertEquals(-1, ans);
  }

  @Test
  public void testMightNotCoPrime4() {
    long[] r = {0};
    long[] m = {1};
    long ans = ChineseRemainderTheorem.solveMightNotCoPrime(r, m);
    assertEquals(0, ans);
  }

  @Test
  public void testMightNotCoPrime5() {
    long[] r = {1, 0, 3, 4, 3, 1, 3, 0, 9, 0, 3};
    long[] m = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    long ans = ChineseRemainderTheorem.solveMightNotCoPrime(r, m);
    assertEquals(99, ans);
  }

  @Test
  public void testMightNotCoPrime6() {
    long[] r = {1, 0, 3, 4, 3, 1, 3, 0, 9, 0, 9};
    long[] m = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13};
    long ans = ChineseRemainderTheorem.solveMightNotCoPrime(r, m);
    assertEquals(277299, ans);
  }

  // @Test Overflow?
  public void testMightNotCoPrime7() {
    long[] r = {123456789, 123456777};
    long[] m = {2000000000, 1999999999};
    long ans = ChineseRemainderTheorem.solveMightNotCoPrime(r, m);
    assertEquals(3999999974123456789L, ans);
  }
}
