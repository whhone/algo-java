package tests.math;

import org.junit.Test;
import weapon.math.Primes;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class PrimesTest {

  @Test
  public void test1() {
    ArrayList<Long> primes = Primes.getPrimesLessThanOrEqual(1);
    assertEquals(0, primes.size());
  }

  @Test
  public void test2() {
    ArrayList<Long> primes = Primes.getPrimesLessThanOrEqual(2);
    assertEquals(1, primes.size());
    assertEquals(2, primes.get(0).intValue());
  }

  @Test
  public void test3() {
    ArrayList<Long> primes = Primes.getPrimesLessThanOrEqual(3);
    assertEquals(2, primes.size());
    assertEquals(2, primes.get(0).intValue());
    assertEquals(3, primes.get(1).intValue());
  }

  @Test
  public void test100() {
    ArrayList<Long> primes = Primes.getPrimesLessThanOrEqual(100);
    assertEquals(25, primes.size());
    assertEquals(2, primes.get(0).intValue());
    assertEquals(3, primes.get(1).intValue());
    assertEquals(97, primes.get(24).intValue());
  }

  @Test
  public void testSmallPrimeDivisor() {
    assertEquals(2, Primes.smallestPrimeDivisor(2));
    assertEquals(3, Primes.smallestPrimeDivisor(3));
    assertEquals(2, Primes.smallestPrimeDivisor(4));
    assertEquals(5, Primes.smallestPrimeDivisor(5));
    assertEquals(2, Primes.smallestPrimeDivisor(6));
    assertEquals(7, Primes.smallestPrimeDivisor(7));
    assertEquals(2, Primes.smallestPrimeDivisor(8));
    assertEquals(3, Primes.smallestPrimeDivisor(9));
  }

  @Test
  public void testIsPrime() {
    assertFalse(Primes.isPrime(0));
    assertFalse(Primes.isPrime(1));
    assertTrue(Primes.isPrime(2));
    assertTrue(Primes.isPrime(3));
    assertFalse(Primes.isPrime(4));
    assertTrue(Primes.isPrime(5));
    assertFalse(Primes.isPrime(6));
    assertTrue(Primes.isPrime(7));
    assertFalse(Primes.isPrime(8));
    assertFalse(Primes.isPrime(9));
  }
}
