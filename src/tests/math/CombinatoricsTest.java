package tests.math;

import org.junit.Test;
import weapon.math.Combinatorics;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CombinatoricsTest {

  @Test
  public void testC() {
    assertEquals(BigInteger.valueOf(1), Combinatorics.C(0, 0));

    assertEquals(BigInteger.valueOf(1), Combinatorics.C(1, 1));
    assertEquals(BigInteger.valueOf(1), Combinatorics.C(1, 0));

    assertEquals(BigInteger.valueOf(1), Combinatorics.C(2, 0));
    assertEquals(BigInteger.valueOf(2), Combinatorics.C(2, 1));
    assertEquals(BigInteger.valueOf(1), Combinatorics.C(2, 2));

    assertEquals(BigInteger.valueOf(1), Combinatorics.C(3, 0));
    assertEquals(BigInteger.valueOf(3), Combinatorics.C(3, 1));
    assertEquals(BigInteger.valueOf(3), Combinatorics.C(3, 2));
    assertEquals(BigInteger.valueOf(1), Combinatorics.C(3, 3));

    assertEquals(BigInteger.valueOf(252), Combinatorics.C(10, 5));
    assertEquals(new BigInteger("100891344545564193334812497256"), Combinatorics.C(100, 50));
    assertEquals(new BigInteger(
        "505494984993553222131399078190977848334380300969886818707668059155627" +
            "224800805513588364218349172376025995317495804284602594375785895146237" +
            "5963470"), Combinatorics.C(500, 300));
  }

  @Test
  public void testP() {
    assertEquals(BigInteger.valueOf(1), Combinatorics.P(0, 0));

    assertEquals(BigInteger.valueOf(1), Combinatorics.P(1, 1));
    assertEquals(BigInteger.valueOf(1), Combinatorics.P(1, 0));

    assertEquals(BigInteger.valueOf(1), Combinatorics.P(2, 0));
    assertEquals(BigInteger.valueOf(2), Combinatorics.P(2, 1));
    assertEquals(BigInteger.valueOf(2), Combinatorics.P(2, 2));

    assertEquals(BigInteger.valueOf(1), Combinatorics.P(3, 0));
    assertEquals(BigInteger.valueOf(3), Combinatorics.P(3, 1));
    assertEquals(BigInteger.valueOf(6), Combinatorics.P(3, 2));
    assertEquals(BigInteger.valueOf(6), Combinatorics.P(3, 3));

    assertEquals(BigInteger.valueOf(30240), Combinatorics.P(10, 5));
    assertEquals(new BigInteger(
        "30685187562549660372027304595294697392284597216" +
        "84688959447786986982158958772355072000000000000"), Combinatorics.P(100, 50));
  }
}
