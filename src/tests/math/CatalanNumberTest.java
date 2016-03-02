package tests.math;

import org.junit.Test;
import weapon.math.CatalanNumber;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CatalanNumberTest {

  @Test
  public void test() {
    assertEquals(BigInteger.valueOf(1), CatalanNumber.get(0));
    assertEquals(BigInteger.valueOf(1), CatalanNumber.get(1));
    assertEquals(BigInteger.valueOf(2), CatalanNumber.get(2));
    assertEquals(BigInteger.valueOf(5), CatalanNumber.get(3));
    assertEquals(BigInteger.valueOf(14), CatalanNumber.get(4));
    assertEquals(BigInteger.valueOf(42), CatalanNumber.get(5));
    assertEquals(BigInteger.valueOf(132), CatalanNumber.get(6));
    assertEquals(BigInteger.valueOf(429), CatalanNumber.get(7));
    
    assertEquals(
        new BigInteger("896519947090131496687170070074100632420837521538745909320"),
        CatalanNumber.get(100));
  }
}
