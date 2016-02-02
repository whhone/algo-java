package tests.math;

import org.junit.Test;
import weapon.math.Primes;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class PrimesTest {

  @Test
  public void test1() {
    ArrayList<Long> primes = Primes.getPrimes(1);
    assertEquals(0, primes.size());
  }

  @Test
  public void test2() {
    ArrayList<Long> primes = Primes.getPrimes(2);
    assertEquals(1, primes.size());
    assertEquals(2, primes.get(0).intValue());
  }

  @Test
  public void test3() {
    ArrayList<Long> primes = Primes.getPrimes(3);
    assertEquals(2, primes.size());
    assertEquals(2, primes.get(0).intValue());
    assertEquals(3, primes.get(1).intValue());
  }

  @Test
  public void test100() {
    ArrayList<Long> primes = Primes.getPrimes(100);
    assertEquals(25, primes.size());
    assertEquals(2, primes.get(0).intValue());
    assertEquals(3, primes.get(1).intValue());
    assertEquals(97, primes.get(24).intValue());
  }
}
